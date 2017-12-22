import csv
import argparse
import pandas as pd
import sys

file_is_empty = 4
does_not_match_length = 5
time_diff_error_code =6
max_diff_time = 5
macId_does_not_exist = 7


def main():
	print "Call the validateCSV function to test program"
	
def getDataFrame(csvFile, withHeader = True):
	df = None
	try:
		df = pd.read_csv(csvFile) if withHeader == True else pd.read_csv(csvFile, header=None)
	except:
		failure(file_is_empty, csvFile + ' should have non-zero lines')
	return df;

def validateCSVNonZeroLine(csvFile, withHeader = True):
	#Read the CSV file
	df = getDataFrame(csvFile, withHeader)
	if len(df.index) == 0:
		failure(file_is_empty, csvFile + ' should have non-zero lines')
		
def validateCSVSameNumberOfLine(csvFileOne, csvFileTwo, withHeader = True):
	validateCSVNonZeroLine(csvFileOne, withHeader)
	validateCSVNonZeroLine(csvFileTwo, withHeader)
	dfOne = getDataFrame(csvFileOne, withHeader)
	dfTwo = getDataFrame(csvFileTwo, withHeader)
	if len(dfOne.index) != len(dfTwo.index):
		failure(does_not_match_length, '{} and {} length does not match'.format(csvFileOne, csvFileTwo))
	return len(dfOne.index)

def checkDiff(ThirdRowTime, FifthRowTime, time):
	
	if (time - max_diff_time <= ThirdRowTime and time + max_diff_time >= ThirdRowTime):
		return True if (time - max_diff_time <= FifthRowTime and time + max_diff_time >= FifthRowTime) else False
	else:
		return False
		

def validateStartAndEndTime(csvFile, startTime, endTime, withHeader = True):
	df = getDataFrame(csvFile, withHeader)
	ThirdRowTime = int(df.iloc[0][2])
	FifthRowTime = int(df.iloc[0][4])
	if checkDiff(ThirdRowTime, FifthRowTime, startTime) == False:
		failure(time_diff_error_code, '{} first row time does not match condition'.format(csvFile))
	ThirdRowTime = int(df.iloc[-1][2])
	FifthRowTime = int(df.iloc[-1][4])	
	if checkDiff(ThirdRowTime, FifthRowTime, endTime) == False:
		failure(time_diff_error_code, '{} last row time does not match condition'.format(csvFile))

def failure(error_code, error_message):
    sys.stderr.write("\nFAILURE : " + error_message+"\n\n")
    sys.exit(error_code)

def doesTagIdExistInBothFile(rawDataCSV, fixturesCSV, withHeader = True):
	rawDataDF = getDataFrame(rawDataCSV, withHeader)
	fixturesDF = getDataFrame(fixturesCSV, withHeader)
	unMatchMacIdDF = rawDataDF[~rawDataDF.sensor_address.isin(fixturesDF.mac.values)]
	if len(unMatchMacIdDF.index) > 0:
		print "Unmatch macID(s)"
		print unMatchMacIdDF
		failure(macId_does_not_exist, "{} macID does not match with the {} macID".format(rawDataCSV, fixturesCSV))

if __name__ == "__main__":
    main()