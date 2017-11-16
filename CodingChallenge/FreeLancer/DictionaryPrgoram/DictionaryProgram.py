def runProgram(fileList):
	printFiles(fileList)
	fileName = takeInput(fileList)
	dic = getDicFromFile(fileName)
	count = askNumber(len(dic))
	worngWordDic = quizzed(dic, count)
	print('''
	Do you want to export wrong word to txt file?
	1. yes
	2. no
	''')
	question = int(input())
	if(question == 1):
		name = input("please enter file name: ")
		exportFile(name, worngWordDic)
	else:
		print "bye. See you soon"

#Export file
def exportFile(name, worngWordDic):
	name = name + ".txt"
	f = open(name,"w")
	for x in worngWordDic:
		f.write(x + ":" + worngWordDic[x] + "\n")
	f.close()
	print (name + " is created. \nThank you, Bye")

import random

#Quizzed function to start quiz	
def quizzed(dic, count):
	wrong = {}
	k = dic.keys()
	random.shuffle(k)
	for i in range(count):
		ans = input(k[i] + " = ")
		l = dic[k[i]].split(',')
		l[-1] = l[-1].strip()
		if(ans not in l):
			wrong[k[i]] = ans
			print "Wrong"
		else:
			print "correct"
	return wrong

#ask number to user and validate the user input
def askNumber(count):
	userCount = input("Please enter number of words you would like to be quizzed on: ")
	while(userCount  < 1 or userCount  > count):
		print ("\nnumber should be between one and the number of English words in the dictionary")
		userCount = input("Please enter number of words you would like to be quizzed on: ")
	return userCount
	
#create dictionary using files.
def getDicFromFile(fileName):
	#f = open(fileName, "r")
	#print f.read()
	dic = {}
	with open(fileName) as f:
		for line in f:
			(key, val) = line.split(':')
			dic[key] = val
	print ("\nThere is total " + str(len(dic)) + " words.\n")
	return dic

#take input from user on which files we want to attend quiz
def takeInput(fileList):
	fileName = input("which vocabulary file you would like to use: ")
	while(fileName not in fileList):
		print ("\n" +fileName + " is not exist, Please try again\n")
		fileName = input("which vocabulary file you would like to use:")
	return fileName
		
#print function
def printFiles(fileList):
	print ("Files are "),
	print fileList	

#Stop function and say bye
def quitProgram():
	print "I am not able to find file in directory. Sorry :("

#starting of the program
import glob

fileList = glob.glob('*.txt')

if(len(fileList) > 0):
	runProgram(fileList)
else:
	quitProgram()
	
