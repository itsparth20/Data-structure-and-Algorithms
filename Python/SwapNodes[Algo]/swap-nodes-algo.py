#!/bin/python3

import os
import sys
from collections import deque

#
# Complete the swapNodes function below.
#

def _print_value(node):
        print (node.value)
        if node.left:            
            print (node.left.value)
        else:
            print (-1)
        if node.right:
            print (node.right.value)
        else:
            print (-1)

class Node(object):
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def create_tree(indexes):
    root = Node(1)
    queue = deque()
    queue.appendleft(root)
    for left, right in indexes:
        temp = queue.pop()
        if left != -1:
            temp.left = Node(left)
            queue.appendleft(temp.left)
        if right != -1:
            temp.right = Node(right)
            queue.appendleft(temp.right)
    
    if len(queue) > 0:
        print ("something may wrong")

    return root


def _in_order(node, lst):
    if node is None:
        return
    _in_order(node.left, lst)
    lst.append(node.value)
    _in_order(node.right, lst)


def in_order_traversal(root):
    in_order_lst = []
    _in_order(root, in_order_lst)
    return in_order_lst


def _swap(node, k, level):
    if node is None:
        return
    if level/k == int(level/k):        
        node.left, node.right = node.right, node.left
    _swap(node.left, k, level+1)
    _swap(node.right, k, level+1)

def swap_node(root, queries):
    in_order_lst = []
    for k in queries:
        _swap(root, k, 1)
        in_order_lst.append(in_order_traversal(root))
    return in_order_lst
    

def swapNodes(indexes, queries):
    in_order_lst = []
    root = create_tree(indexes)

    in_order_lst = swap_node(root, queries)
    return in_order_lst

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    indexes = []

    for _ in range(n):
        indexes.append(list(map(int, input().rstrip().split())))

    queries_count = int(input())

    queries = []

    for _ in range(queries_count):
        queries_item = int(input())
        queries.append(queries_item)

    result = swapNodes(indexes, queries)

    fptr.write('\n'.join([' '.join(map(str, x)) for x in result]))
    fptr.write('\n')

    fptr.close()
