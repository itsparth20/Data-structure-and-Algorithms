def isValid(s):
    lst = list(s)
    dic = {'}': '{',')' : '(',']' : '['}
    stk = []
    for i in range(len(s)):
        if s[i] in dic.keys():
        	if len(stk) == 0 or stk.pop() != dic[s[i]]:
        		return False
        else:
        	stk.append(s[i])
    return True if len(stk) == 0 else False
    
print isValid('()')