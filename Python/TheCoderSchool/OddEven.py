print('Enter Number')
num = int ( input() )
if num == 0:
	print ('0 is not even or odd')
elif num % 2 == 0:
	print (str(num)+' is even')
else:
	print (str(num)+' is odd')