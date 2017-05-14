print ('Enter any number')
num = int( input() )
prime = True
if num < 2:
	print ('Number is not prime')
	prime = False
else:
	for i in range(2,num):	
		if num % i == 0:
			print ('Your number ' +str(num)+ ' is not prime')
			prime = False
			break

if prime:
	print ('Your number ' +str(num)+ ' is prime')