import csv
import argparse
import pandas as pd

def parse_args():
    parser = argparse.ArgumentParser(description='Calculate data');
    parser.add_argument('src_file', help="Source csv file")
    parser.add_argument('dest_file', help="Destination csv file")
    return parser.parse_args()

def exportFile(src_file, dest_file):
    lstRange = [-10000, -5000, -2000, -1000, -500, -200, 200, 500, 1000, 2000, 5000, 10000]
    lstCount = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    dic = {}
    df = pd.read_csv(src_file, header=None, usecols=[2,4])
    for index, row in df.iterrows():
        timeDiff = df.ix[index,2] - df.ix[index,4]
        if timeDiff < lstRange[0]:
            lstCount[0] += 1
        elif timeDiff >= lstRange[len(lstRange)-1]:
            lstCount[len(lstRange)] += 1
        else:
            for i in range(1,len(lstRange)):
                if timeDiff >= lstRange[i-1] and timeDiff < lstRange[i]:
                    lstCount[i] += 1
                    break
    condition = []
    first = str(lstRange[0]) + " >"
    condition.append(first)
    for i in range(1,len(lstRange)):
        name = str(lstRange[i-1]) + " to " + str(lstRange[i]-1)
        condition.append(name)
    last = str(lstRange[len(lstRange)-1]) + " <="
    condition.append(last)
    total = sum(lstCount[0:len(lstCount)])
    condition.append('Total')
    lstCount.append(total)
    dic['Range'] = condition
    dic['Count'] = lstCount
    newDf = pd.DataFrame(dic)
    print newDf
    newDf.to_csv(dest_file, index=False)

def main():
    args = parse_args()
    exportFile(args.src_file, args.dest_file)

if __name__ == "__main__":
    main()
