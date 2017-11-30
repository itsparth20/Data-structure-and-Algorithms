import argparse
import pandas as pd

beacon_interval=300.0
rollover_limit=128
rollover_interval=rollover_limit*300

def parse_args():
    parser = argparse.ArgumentParser(description='Calculate data');
    parser.add_argument('src_file', help="Source csv file")
    parser.add_argument('dest_file', help="Unwrapped csv file")
    return parser.parse_args()
	
def exportFile(src_file, dest_file):
        df = pd.read_csv(src_file, header=None)
	baseTime = 0
	#Iterate over dataframe
	for index, row in df.iterrows():
		seqNum = df.ix[index,9]
		if baseTime == 0:
			baseTime = df.ix[index,2] - (seqNum * beacon_interval)
		else:
			time_offset  = baseTime + (seqNum * beacon_interval) - df.ix[index,2] 
			if time_offset > -0.5*rollover_interval and time_offset < 0.5*rollover_interval:
				pass
			else:
				seqNum += rollover_limit* int(round((df.ix[index,2] - baseTime- (seqNum * beacon_interval))/rollover_interval))
		df.ix[index,9] = seqNum

	df.to_csv(dest_file, header=False, index=False)

def main():
	args = parse_args()
	exportFile(args.src_file, args.dest_file)

if __name__ == "__main__":
    main()
