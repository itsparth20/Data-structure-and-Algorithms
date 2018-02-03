#python web_crawler.py https://www.rescale.com/
from urllib.request import Request, urlopen
import argparse
import queue
import threading
import concurrent.futures
from bs4 import BeautifulSoup
# set up queue
url_queue = queue.Queue()
# created a lock to work with shared object
lock = threading.Lock()
# created a set to store all visited links
set = set()
#number of threads
total_thread = 30

def web_crawler():
	while True:
		try:
			#get url from queue. 
			base_url = url_queue.get(True, 5).strip()
			try:
				# add new url to set. If visited url, then skip crawling
				lock.acquire()
				if base_url in set:
					url_queue.task_done()
					continue
				else:
					set.add(base_url)
			finally:
				lock.release()
			try:
				# get all urls of page and add to queue
				str_url = base_url
				req = Request(base_url, headers={'User-Agent': 'Mozilla/5.0'})
				html = urlopen(req).read()
				# BeautifulSoup to get all the <a href> tag url
				bs = BeautifulSoup(html, "html.parser")
				possible_links = bs.find_all('a')
				for link in possible_links:
					if link.has_attr('href') and ("http" in link.attrs['href'] or "https" in link.attrs['href']) and ".pdf" not in link.attrs['href'] and ".png" not in link.attrs['href'] and ".jpg" not in link.attrs['href'] and ".jpeg" not in link.attrs['href']:
						str_url += "\n\t" + (link.attrs['href'])
						url_queue.put((link.attrs['href']))
				lock.acquire()
				print (str_url)
				lock.release()
			except Exception as e:
				print ("Error: " + str(e))
			url_queue.task_done()
		except queue.Empty:
			break
# parse the argument
def parse_args():
    parser = argparse.ArgumentParser(description='Script for Web Crawler')
    parser.add_argument('url',help='Starting URL')
    return parser.parse_args()
	
def main():
	args = parse_args()
	# add starting url to queue
	url_queue.put(args.url)
	data = []
	for x in range(total_thread):
		data.append(x)
	# Created threadPool to work with multiple threads
	with concurrent.futures.ThreadPoolExecutor(max_workers=total_thread) as executor:
		future_result = {executor.submit(web_crawler): x for x in data}
		for future in concurrent.futures.as_completed(future_result):
			thread_no = future_result[future]
			try:
				result = future.result()
			except Exception as exc:
				print('%r generated an exception: %s' % (thread_no, exc))
	url_queue.join()

if __name__ == "__main__":
    main()