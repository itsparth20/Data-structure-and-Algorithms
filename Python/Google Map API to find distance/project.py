import requests
class Tour:
	def __init__(self,*name):
		self.lst = []
		for city in name:
			self.lst.append(city)
	def distance(self, mode='driving'):
		dis = 0;
		for i in range(len(self.lst)-1):
			sources = self.lst[i].replace(' ','+')
			sources = sources.replace(' ','+')
			destinations = self.lst[i+1].replace(',+',',')
			destinations = destinations.replace(',+',',')
			url = 'http://maps.googleapis.com/maps/api/distancematrix/json?origins={}&destinations={}&mode={}&sensor=false'.format(sources, destinations, mode)
			response = requests.get(url)
			data = response.json()
			data = data['rows'][0]
			data = data['elements'][0]
			try:
				if 'distance' in data:
					data = data['distance']
					dis += data['value']
				else:
					raise ValueError('response does not contain a distance value')
			except Exception as error:
				print('Caught this error: ' + repr(error))
		return dis
	def __str__(self):
		str = ''
		ad = ''
		for x in self.lst:
			str += ad
			str += x
			ad = '; '
		return str
	def __repr__(self):
		str = ''
		ad = ''
		for x in self.lst:
			str += ad
			str += x
			ad = '; '
		return str
	def __add__(self, tour):		
		city = self.lst + tour.lst
		t = Tour()
		t.lst = city
		return t
	def __mul__(self, no):
		try:
			if isinstance(no, int) and no > 0:
				return self.lst * no
			else:
				raise ValueError('Input should be non-negative')
		except Exception as error:
				print('Caught this error: ' + repr(error))
		
	__rmul__ = __mul__
	
	def __gt__(self, tour):
		selfTourDis = self.distance()
		tourDis = tour.distance()
		return True if selfTourDis > tourDis else False
	
	def __lt__(self, tour):
		selfTourDis = self.distance()
		tourDis = tour.distance()
		return True if selfTourDis < tourDis else False
	
	def __eq__(self, tour):
		selfTourDis = self.distance()
		tourDis = tour.distance()
		return True if selfTourDis == tourDis else False
	
	
def main():
	t1 = Tour("New York, NY", "Lansing, MI", "Sacramento, CA")
	t2 = Tour("Oakland, CA")
	t3 = Tour("Sacramento, CA", "Oakland, CA")
	print("t1: {}\nt2:{}\nt3:{}".format(t1,t2,t3))
	print("t1 distances: driving-{} km; biking-{} km; walking-{} km".format(round(t1.distance()/1000), round(t1.distance('bicycling')/1000), round(t1.distance('walking')/1000)))
	print("Using driving distances from here on.")
	t4 = t1 + t2
	print("t4:", t4)
	print("t4 driving distance:", round(t4.distance()/1000),"km")
	print("t4 == t1 + t2:", t4 == t1 + t2)
	print("t1 > t4: ", t1>t4)
	print("t1 < t4: ", t1<t4)
	print ("t3 * 2: ", t3 * 2)
	
main()

