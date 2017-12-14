def main():
	#sort the list
	lst.sort()
	#print the list
	print "List: ", lst
	#take user input to be search
	search = int(input("Enter number to be search: "))
	#init first index and last index
	f = 0
	l = len(lst) - 1
	
	#run a loop while f<=l
	while f <= l:
		#find mid point and compare the value of it. Move first or last pointer based on mid point value
		mid = (f+l)/2
		if lst[mid] == search:
			return True
		elif lst[mid] > search:
			l = mid - 1
		else:
			f = mid + 1
	#if we do not find the value in list then return false
	return False
#List
lst = [20, 151, 37, 13, 220, 181, 81, 160, 91, 243, 60]
print main()