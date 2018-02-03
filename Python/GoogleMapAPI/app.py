import threading
import queue
import csv
import googlemaps
import config
import os

"""
Replace last occurence of a string within a string
Source at https://stackoverflow.com/questions/2556108/rreplace-how-to-replace-the-last-occurrence-of-an-expression-in-a-string
"""
def rreplace(s, old, new, occurrence):
	li = s.rsplit(old, occurrence)
	return new.join(li)

"""
Simple wrapper for geocode returning None if maps api fails
"""
def geocode(result): 
	try:
		return result[0]["geometry"]["location"]
	except Exception as e:
		print("Geocode error: " + str(e))
		return None
#get street Number
def getDataFromResults(result, name): 
	try:
		data = ""
		for obj in result[0]["address_components"]:
			if name in obj["types"]:
				data = obj["long_name"]
				break
				
		return data
	except Exception as e:
		print("Geocode error: " + str(e))
		return None
def getShortNameFromResults(result, name): 
	try:
		data = ""
		for obj in result[0]["address_components"]:
			if name in obj["types"]:
				data = obj["short_name"]
				break
				
		return data
	except Exception as e:
		print("Geocode error: " + str(e))
		return None
		
def checkNone(data, flag):
	if flag:
		return flag
	else:
		return False if data else True

def geocoding_worker():
	global row_counter

	# init google maps client of the thread
	gclient = googlemaps.Client(key=config.GOOGLE_MAPS_API_KEY)

	while True:
		try:
			row = geocoding_queue.get(True, 5)

			latitude = longitude = None
			none = False
			try:
				address = row[config.ADDRESS_INDEX - 1]	
				none = checkNone(address, none)	
				# remove County from address, it's failing google maps
				result = gclient.geocode(rreplace(address, 'County', '', 1))				
				none = checkNone(result, none)
				location = geocode(result)
				none = checkNone(location, none)
				street_number = getDataFromResults(result,'street_number')
				
				political = getDataFromResults(result,'locality')
				
				administrative_area_level_2 = getDataFromResults(result,'administrative_area_level_2')
				
				administrative_area_level_1 = getDataFromResults(result,'administrative_area_level_1')
				
				administrative_area_level_1_sortName = getShortNameFromResults(result,'administrative_area_level_1')
				
				political = getDataFromResults(result,'locality')
				
				route = getDataFromResults(result,'route')
				
				postal_code = getDataFromResults(result,'postal_code')
				
				country = getDataFromResults(result,'country')
				latitude = None
				longitude = None
				# latitude and longitude key names are untouched, same as returned by google maps
				if location is not None and "lat" in location and "lng" in location:
					latitude = float("{0:.6f}".format(location["lat"]))
					longitude = float("{0:.6f}".format(location["lng"]))
				else:
					none = True
					
				col_count = len(row)		
				
				row[col_count - 10] = latitude					
				row[col_count - 9] = longitude
				row[col_count - 8] = str(street_number)
				row[col_count - 7] = route
				row[col_count - 6] = political
				row[col_count - 5] = administrative_area_level_2
				row[col_count - 4] = administrative_area_level_1
				row[col_count - 3] = administrative_area_level_1_sortName
				row[col_count - 2] = str(postal_code)
				row[col_count - 1] = str(country)
			except IndexError:
				pass				

			with ocsv_lock:
				
				print("{}. {} | {}".format(row_counter, address, 
					"{} | {}".format(str(latitude), str(longitude)) if latitude and longitude else "FAILED"))
				
				row_counter += 1
				
				ecsv_writer.writerow(row) if none else ocsv_writer.writerow(row)

			geocoding_queue.task_done()
		except queue.Empty:
			break

try:
	# init google maps client
	gclient = googlemaps.Client(key=config.GOOGLE_MAPS_API_KEY)

	print("Geocoding..")

	# set up workers and queue
	geocoding_queue = queue.Queue(20)
	threads = []

	ocsv_writer = None
	ecsv_writer = None
	row_counter = 1
	ocsv_lock = threading.Lock()

	# 10 workers will be used
	for i in range(10):
		t = threading.Thread(target=geocoding_worker)
		t.start()
		threads.append(t)
	
	with open(config.INPUT_CSV_FILE, "r") as icsv, open(config.TEMP_OUTPUT_CSV_FILE, "w", newline='') as ocsv, open(config.ERROR_CSV_FILE, "w", newline='') as ecsv:
		reader = csv.reader(icsv, delimiter=",")
		ocsv_writer = csv.writer(ocsv, delimiter=",")
		ecsv_writer = csv.writer(ecsv, delimiter=",")

		# read from input csv line by line
		for i, row in enumerate(reader):
			# Write header row
			if i == 0:
				ocsv_writer.writerow(row)
				ecsv_writer.writerow(row)
			elif len(row) > 0:
				geocoding_queue.put(row)

		# wait for the jobs to complete
		geocoding_queue.join()

		# wait for the thread to complete
		for t in threads:
			t.join()
		print("Complete")
	os.rename(config.TEMP_OUTPUT_CSV_FILE, config.OUTPUT_CSV_FILE)
except Exception as e:
	print(e)