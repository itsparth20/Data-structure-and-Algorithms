import math
class Vector:
	def __init__(self, x, y):
		self.x = x
		self.y = y
		
	def __str__(self):
		return ("X is " + str(self.x) + ", Y is " + str(self.y))
		
	def __add__(self,v1):
		x = self.x + v1.x
		y = self.y + v1.y
		return Vector(x,y)
		
	def __mul__(self,v1):
		x = self.x * v1.x
		y = self.y * v1.y
		return Vector(x,y)
	
	def __sub__(self, v):
		z = v*Vector(-1,-1)
		return self+z
		
def getVector():
	x = int(input('Enter X: '))
	y = int(input('Enter Y: '))
	return Vector(x,y)

def add():
	print ("\nEnter First vector")
	v1 = getVector()
	print ("\nEnter Second vector")
	v2 = getVector()
	v3 = v1 + v2
	print (v3)

def mul():
	print ("\nEnter First vector")
	v1 = getVector()
	print ("\nEnter Second vector")
	v2 = getVector()
	v3 = v1 * v2
	print (v3)

def mulDot():
    print ("\nEnter First vector")
    v1 = getVector()
    print ("\nEnter n")
    n = int(input())
    v3 = Vector(n,n)
    v2 = v1 * v3
    print (v2)
def sub():
	print ("\nEnter First vector")
	v1 = getVector()
	print ("\nEnter Second vector")
	v2 = getVector()
	v3 = v1 - v2
	print (v3)
	
def magnitude():
	print ("\nEnter First vector")
	v1 = getVector()
	print (math.hypot(v1.x,v1.y))

def printInput():
	print('''
	1. Addition
	2. Multiplication (2 Veector)
	3. Multiplication (Dot product)
	4. Subtraction
	5. Magnitude
	6. Exit
	''')
def main():
	printInput()
	
	ch = int(input())
	while(ch != 6):
		if(ch == 1):
			add()
		elif(ch == 2):
			mul()
		elif(ch == 3):
			mulDot();
		elif(ch == 4):
			sub()
		elif(ch == 5):
			magnitude()
		else:
			print ("please try again (eg. 1 to 5)")
		printInput()
		ch = int(input())
	
	print("Bye...")

main()
