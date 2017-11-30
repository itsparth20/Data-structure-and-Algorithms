import argparse
import pandas as pd

def parse_args():
    parser = argparse.ArgumentParser(description='Calculate data');
    parser.add_argument('file', help="file Name")
    return parser.parse_args()
	
def exportFile(df, args):
	baseTime = 0
	#Iterate over dataframe
	for index, row in df.iterrows():
		seqNum = df.ix[index,9]
		if baseTime == 0:
			baseTime = df.ix[index,2] - (seqNum * 0.3)
		else:
			temp  = baseTime + (seqNum * 0.3) - df.ix[index,2] 
			if temp > -38.4 and temp < 38.4:
				pass
			else:
				seqNum += 256* int(round((df.ix[index,2] - baseTime- (seqNum * 0.3))/78.6))
		df.ix[index,9] = seqNum
	df.to_csv('output_'+args.file, header=False, index=False)

def main():
	#get arguments
	args = parse_args()
	#create dataframe
	df = pd.read_csv(args.file, header=None)	
	exportFile(df, args)
		

if __name__ == "__main__":
    main()