#!/bin/python3

import os
import sys

#
# Complete the runningMedian function below.
#

class LinkedList(object):
    def __init__(self, value, next_node = None):
        self.value = value
        self.next_node = next_node

def add_node_to_linkedlist(node, value):
    
    head = node
    new_node = None
    
    if node.value > value:
        new_node = LinkedList(value, head)
        return new_node
    
    while node.next_node is not None:
        if node.next_node.value >= value:
            new_node = LinkedList(value, node.next_node)
            node.next_node = new_node
            return head
        else:
            node = node.next_node

    node.next_node = LinkedList(value)
    return head
    

def runningMedian(a):
    length = len(a)
    medians = []
    head = LinkedList(a[0])
    new_head = head
    medians.append(float(head.value))
    
    for i in range(1, length):        
        new_head = add_node_to_linkedlist(head, a[i])
        head = new_head
        # while new_head is not None:
        #     print (new_head.value)
        #     new_head = new_head.next_node
        
        # print ()

        node = head
        total = i+1
        if total%2 == 0:
            right = total/2
            left = right-1
            while left >= 0:
                
                if left == 0:
                    median = (node.value + node.next_node.value) / 2.0
                    medians.append(median)
                else:
                    node = node.next_node
                left = left - 1
        else:
            left = int(total/2)
            while left >= 0:                                
                if left == 0:
                    median = float(node.value)
                    medians.append(median)
                else:
                    node = node.next_node
                left -= 1 


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
