#!/bin/python3

import os
import sys

#
# Complete the contacts function below.
#
def contacts(queries):
    #
    # Write your code here.
    #
    dic = {}
    lst = []
    for query in queries:
        op = query[0]
        word = query[1]
        if op == 'add':
            length = len(word)
            for i in range(1, length+1):
                if word[:i] in dic:
                    dic[word[:i]] += 1
                else:
                    dic[word[:i]] = 1            
        else:
            lst.append(dic.get(word, 0))
    
    return lst

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    queries_rows = int(input())

    queries = []

    for _ in range(queries_rows):
        queries.append(input().rstrip().split())

    result = contacts(queries)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
