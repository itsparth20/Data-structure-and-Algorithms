#!/bin/python

from __future__ import print_function

import os
import sys

#
# Complete the contacts function below.
#
class Node(object):
    def __init__(self, ch):
        self.ch = ch
        self.total = 1
        self.dic = {}

    def __str__(self):
        print (self.ch)
        print (self.total)
        print (self.dic)


def char_exist(ch, dic):
    return ch in dic


def add_name(name, dic):
    if len(name) <= 0:
        return 

    ch = name[0]
    if char_exist(ch, dic):
        node = dic.get(ch)
        node.total += 1
    else:
        node = Node(ch)
        dic[ch] = node 
    add_name(name[1:], node.dic)


def find(name, dic):
    length = len(name) - 1
    for i, s in enumerate(name):
        if s not in dic:
            return 0
        else:
            if i == length:
                return dic.get(s).total
            dic = dic.get(s).dic
    
    
def contacts(queries):
    dic = {}
    lst = []
    for query in queries:
        op = query[0]
        word = query[1]
        if op == 'add':
            add_name(word, dic)
        else:
            count = find(word, dic)
            lst.append(count)
    return lst
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    queries_rows = int(raw_input())

    queries = []

    for _ in xrange(queries_rows):
        queries.append(raw_input().rstrip().split())

    result = contacts(queries)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
