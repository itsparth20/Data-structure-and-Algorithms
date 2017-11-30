import pandas as pd
import argparse

def parse_args():
    parser = argparse.ArgumentParser(description='Calculate data');
    parser.add_argument('file', help="file Name")
    return parser.parse_args()

def main():
	#get arguments
	args = parse_args()
	#create dataframe
	df = pd.read_csv(args.file, header=None, usecols=[9,18])
	#change column name
	df.columns = ['series', 'time']
	
	
	#dic = {key : [min, max, diff]}
	dic = {}
	
	#Iterate over dataframe
	for index, row in df.iterrows():
		num = row['series']
		time = row['time']
		if row['series'] not in dic:
			dic[num] = []
			dic[num].append(time)
			dic[num].append(time)
			dic[num].append(0)
		else:
			if time > dic[num][1]:
				dic[num][1] = time
				dic[num][2] = dic[num][1] - dic[num][0]
			elif time < dic[num][0]:
				dic[num][0] = time
				dic[num][2] = dic[num][1] - dic[num][0]

	exportCSV(dic, args)

def exportCSV(dic, args):
	exportDic = {'Series' : [],
					'Minimum' : [],
					'Maximum' : [],
					'Difference' : []}
					
	for key in dic:
		exportDic['Series'].append(key)
		exportDic['Minimum'].append(dic[key][0])
		exportDic['Maximum'].append(dic[key][1])
		exportDic['Difference'].append(dic[key][2])
	
	newDf = pd.DataFrame(exportDic)
	newDf.set_index('Series', inplace = True)
	#newDf.to_csv('output_'+args.file)

if __name__ == "__main__":
    main()