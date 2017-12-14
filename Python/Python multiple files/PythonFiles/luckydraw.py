import Queue
import random
#create queue
que = Queue.Queue()

que.put("Adam")
que.put("Ben")
que.put("Adam")
que.put("Deborah")
que.put("Elvin")

print "Welcome to Pong Pong Shopping Mall Weekly Lucky Draw\n"
i = 1
#print element of the que
for x in list(que.queue):
	print ("Shopper #" + str(i)+ ": "+x)
	i+=1
size = que.qsize()
correct = 0
wrong = 0
#loop over queue
for i in range(size):
	name = que.get()
	print ("\nCalling " + name)
	answerCall = random.randint(1,2)
	print ("Answer the call: " + ("Yes" if answerCall == 1 else "No"))
	#if did not answer the call then call later
	if(answerCall == 2):
		que.put(name)
		print 'Call later'
	#if answer the call then do further steps
	elif(answerCall == 1):
		answer = random.randint(1,2)
		print ("Answer the question correctly: " + ("Yes" if answer == 1 else "No"))
		#if answer is correct than display congo
		if(answer == 1):
			correct += 1
			print "Congratulation!"
		#if answer is wrong then print HAND
		elif(answer == 2):
			wrong += 1
			print 'Have a nice day'
#Display how many are in queue and what percentage of people give correct and wrong answer
print "\nStill in Queue"
for x in list(que.queue):
	print (x)

print "Number of Shoppers who did not pick up the call = ",que.qsize()
print "Percentage of shoppers who picked up the call and answered correctly ={}".format(((100*correct)/size))
print "Percentage of shoppers who picked up the call and did not answer correctly ={}".format(((100*wrong)/size))
