import random
#create a list
def getList():
	lst = ["#1 One call away"]
	lst.append('#2 Firework')
	lst.append('#3 Faded')
	lst.append('#4 I believe I can fly')
	lst.append('#5 Just the way you are')
	return lst

#main method
def main():
	lst = getList()

	no = random.randint(1,10)
	print ("Rnadom Number:")
 	print no
	song = []

	while(no != 9 and no!= 10 and len(lst) > 0):
		song.append(lst.pop())
		no = random.randint(1,10)
		print ("Rnadom Number:")
		print no
	if(no == 9 or no == 10):
		print "Have a nice day"
	elif len(lst) == 0:
		print "no more songs to play"
	
	if(len(song) > 0):
		print "\nWe have played the following song(s)"
		for x in song:
			print x
	
main()