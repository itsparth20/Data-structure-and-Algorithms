#matrix = [[2, -6, -1],[-3, -1, 7],[-8, 1, -2]]
#result = [-38, -34, -20]

matrix = [[5, -1, 2],[3, 8, -2],[1, 1, 4]]
result = [12, -25, 6]
x1 = 0
x2 = 0
x3 = 0

for i in range(5):
	x1 = ( result[0] + ( (matrix[0][1] * -1) * x2) + ( (matrix[0][2] * -1)  * x3) ) / (matrix[0][0])
	x2 = ( result[1] + ( (matrix[1][0] * -1) * x1) + ( (matrix[1][2] * -1)  * x3) ) / (matrix[1][1])
	x3 = ( result[2] + ( (matrix[2][0] * -1) * x1) + ( (matrix[2][1] * -1)  * x2) ) / (matrix[2][2])
	

print (x1)
print (x2)
print (x3)