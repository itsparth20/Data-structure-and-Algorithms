import argparse
import pandas as pd

def parse_args():
    parser = argparse.ArgumentParser(description='Calculate data');
    parser.add_argument('src_file', help="Source csv file")
    parser.add_argument('dest_file', help="Unwrapped csv file")
    return parser.parse_args()

def exportDict(dic):
	tagSeqNum = 'tagSeqNum'
	tagMacAddress = 'tagMacAddress'
	minimum = 'minimum'
	maximum = 'maximum'
	difference = 'difference'
	count = 'count'
	exportDic = {tagSeqNum : [],
					tagMacAddress : [],
					minimum : [],
					maximum : [],
					difference : [],
					count: []}
	lst = []		
	for key in dic:
		exportDic[tagSeqNum].append(dic[key][0])
		exportDic[tagMacAddress].append(dic[key][1])
		exportDic[minimum].append(dic[key][2])
		exportDic[maximum].append(dic[key][3])
		lst.append(dic[key][4])
		exportDic[count].append(dic[key][5])
	exportDic[difference] = lst
	print "Max Diff : " + str(max(lst)) +"\nMin Diff : " + str(min(lst))
	return exportDic
	
	
def exportFile(src_file, dest_file):
	df = pd.read_csv(src_file, header=None, usecols=[4,8,9])
	#dic = {key : [tagSeqNum, tagMacAddress, minimum, maximum, difference]}
	dic = {}
	for index, row in df.iterrows():
		unwrappedSensorUTCMs = df.ix[index,4]
		tagMacAddress = df.ix[index,8]
		tagSeqNum = df.ix[index,9]
		dicKey = str(tagMacAddress) + "-" + str(tagSeqNum)
		if dicKey not in dic:
			lst = [tagSeqNum, tagMacAddress, unwrappedSensorUTCMs, unwrappedSensorUTCMs, 0, 1]
			dic[dicKey] = lst
		else:
			lst = dic[dicKey]
			if lst[2] > unwrappedSensorUTCMs:
				lst[2] = unwrappedSensorUTCMs
				lst[4] = lst[3] - lst[2]
			elif lst[3] < unwrappedSensorUTCMs:
				lst[3] = unwrappedSensorUTCMs
				lst[4] = lst[3] - lst[2]
			lst[5] += 1
	exportDic = exportDict(dic)
	newDf = pd.DataFrame(exportDic)
	newDf.to_csv(dest_file, index=False)

def main():
	args = parse_args()
	exportFile(args.src_file, args.dest_file)

if __name__ == "__main__":
    main()
