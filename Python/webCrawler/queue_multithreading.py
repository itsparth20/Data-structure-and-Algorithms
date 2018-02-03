#python Z:\python\webCrawler\queue_multithreading.py
import queue
import concurrent.futures

q = queue.Queue()
total_thread = 1
def f():

	q.put([42, None, 'hello'])
	q.put([43, None, 'hello world'])
	#q.get()
	print (q.get())
	q.task_done()
	q.task_done()

def g():
	for i in range(10):
		try:
			try:
				break
			finally:
				print ("inside Bye")
			print ("xyz")
		finally:
			print ("bye")
if __name__ == '__main__':
	
	with concurrent.futures.ThreadPoolExecutor() as executor:
		for i in range(total_thread):
			executor.submit(f)
	q.join()
	print (q.qsize())
	g()
