import random

guessesTaken = 0
 
print('Hello! What is your name?')
myName = input()
number = random.randint(1, 20)
print('Well, ' + myName + ', I am thinking of a number between 1 and 20.')
while guessesTaken < 6:
	
	print('Take a guess.') # There are four spaces in front of print.
	guess = int(input())
	guessesTaken = guessesTaken + 1
	if guess < number:
		print('Your guess is low') 
	elif guess > number:
		print('Your guess is high')
	elif guess == number:
         break
if(guess == number):
	print('Great. You got the answer in '+str(guessesTaken)+' number of guesses')
else:
	print('Nope. The number I was thinking of was ' + str(number))