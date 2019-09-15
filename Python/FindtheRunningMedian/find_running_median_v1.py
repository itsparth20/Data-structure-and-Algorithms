#!/bin/python3

import os
import sys

#
# Complete the runningMedian function below.
#
def runningMedian(a):
    #
    # Write your code here.
    #
    lst = []
    i = 0
    medians = []
    for value in a:
        i += 1
        lst.append(value)
        lst.sort()
        j = int(i/2)
        if i%2 == 0:
            median = (lst[j-1] + lst[j])/2.0            
        else:
            median = float(lst[j])
        medians.append(median)
    return medians

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    a_count = int(input())

    a = []

    for _ in range(a_count):
        a_item = int(input())
        a.append(a_item)

    result = runningMedian(a)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
	