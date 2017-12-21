import csv
import argparse
import pandas as pd
from bs4 import BeautifulSoup

def parse_args():
	parser = argparse.ArgumentParser(description='Create Sensor')
	parser.add_argument('svgFile', help="Source svg file")
	parser.add_argument('csvFile', help="csv file of mac, x, y")
	parser.add_argument('outputFile', help="Output file path")
	return parser.parse_args()

def exportSVG(svgFile, csvFile, ouputFile):
	svg = open(svgFile, 'r').read()
	soup = BeautifulSoup(svg, features = 'xml')
	original_tag = soup.svg
	df = pd.read_csv(csvFile)
	for index, row in df.iterrows():
		x = float(row['x'])
		y = float(row['y'])
		circle = soup.new_tag("circle", cx=x, cy=y, r="10")		
		x -= 55
		y += 40
		text = soup.new_tag("text", x=x,  y=y)		
		original_tag.append(circle)
		original_tag.append(text)
		text.string = row['mac']

	f = open(ouputFile, "w")
	f.write(soup.prettify())
	f.close()
	
def main():
	args = parse_args()
	exportSVG(args.svgFile, args.csvFile, args.outputFile)

if __name__ == "__main__":
    main()