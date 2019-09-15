lst = []

def contacts(queries):
    #
    # Write your code here.
    #
    answer = []
    for query in queries:
        op = query[0]
        word = query[1]
        if op == 'add':
            lst.append(word)
        else:
            count = 0        
            for s in lst:
                if s.startswith(word):
                    count += 1
            answer.append(count)
    return answer