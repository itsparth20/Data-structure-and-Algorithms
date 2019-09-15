#!/bin/python3

import os
import sys
import heapq 

#
# Complete the runningMedian function below.
#  

# def print_v(h_1, h_2):
#     print (h_1)
#     print (h_2)
#     print ()

def runningMedian(a):
    medians = []
    min_heap = []
    max_heap = []

    heapq.heapify(min_heap)
    heapq.heapify(max_heap)
    medians.append(float(a[0]))
    heapq.heappush(min_heap, -a[0])
    # print_v(min_heap, max_heap)
    for i in range(1, len(a)):
        value = a[i]
        prev_median = medians[i-1]

        if value > prev_median:
            heapq.heappush(max_heap, value)
        else:
            heapq.heappush(min_heap, (-value))
        
        if abs(len(min_heap)-len(max_heap)) > 1:
            if len(min_heap) > len(max_heap):
                v = (heapq.heappop(min_heap))
                heapq.heappush(max_heap, -v)
            else:
                v = heapq.heappop(max_heap)
                heapq.heappush(min_heap, -v)
            
        if len(min_heap) == len(max_heap):
            min_value = -min_heap[0]
            max_value = max_heap[0]
            medians.append(
                (max_value+min_value)/2.0
            )
        elif len(min_heap) > len(max_heap):
            medians.append(float(-min_heap[0]))
        else:
            medians.append(float(max_heap[0]))
        # print_v(min_heap, max_heap)
        

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
