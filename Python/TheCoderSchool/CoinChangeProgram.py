
def centFun(cent):
	quarters = 0
	dimes = 0
	nickels = 0
	pennies = 0

	quarters = cent/25
	cent %= 25
	dime = cent/10
	cent %= 10

	nickels = cent/5
	cent %= 5
	pennies = cent

	print ("quarters: " + str(quarters))
	print ("dimes: " + str(dimes))
	print ("nickels: " + str(nickels))
	print ("pennies: " + str(cent))

def dollarFun(dollars):
	hundred = 0
	fifty = 0
	twenty = 0
	ten = 0
	five = 0
	two = 0
	one = 0
	
	hundred = dollars/100
	dollars %= 100
	fifty = dollars/50
	dollars %= 50

	twenty = dollars/20
	dollars %= 20
	ten = dollars/10
	dollars %= 10

	five = dollars/5
	dollars %= 5
	two = dollars/2
	dollars %= 2

	one = dollars
	print ("hundred: " + str(hundred))
	print ("fifty: " + str(fifty))
	print ("twenty: " + str(twenty))
	print ("ten: " + str(ten))
	print ("five: " + str(five))
	print ("two: " + str(two))
	print ("one: " + str(one))

def giveMeChange():
	dollar = int(input("XX.__ \n"))
	cent = int(input(str(dollar) + ".XX \n"))
	print("\nHere is your change: \n====================")
	dollarFun(dollar)
	centFun(cent)
	
giveMeChange()