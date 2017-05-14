dic = {}
ls = [3,3,1,2,3,3,1]

for i in ls:
	if dic.has_key(i):
		dic[i] = dic[i]+1
	else:
		dic[i] = 1

print dic