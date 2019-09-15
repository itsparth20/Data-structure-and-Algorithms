'''		
Question: Robot in Maze problem - Count Number of ways in Matrix
matrix = m * n

start = (m-1, 0)
end = (m-1, n-1)

you can go upper right, right, down right
'''
class Point(object):
	def __init__(self, x, y):
		self.x = x
		self.y = y		
	def __hash__(self):
		return hash((self.x, self.y))
	def __eq__(self, other):
		return (
self.__class__ == other.__class and 
self.x == other.x and
self.y == other.y
)
	def get_up_right(self):
		return Point(self.x-1, self.y+1)
	def get_right(self):
		return Point(self.x, self.y+1)
	def get_down_right(self):
		return Point(self.x+1, self.y+1)

def run(matrix):
	start = Point(len(matrix)-1, 0)
	return go(matrix, start, {})

def go(matrix, point, cache):
	if point in cache:
		return cache[start]
if not _within_matrix_range(matrix, point):
return 0
if _reach_destination(matrix, point):
	return 1

up_right = go(matrix, point.get_up_right(), cache)
right = go(matrix, point.right(), cache)
down_right = go(matrix, point.get_down_right(), cache)

total = up_right + right + down_right
cache[point] = total
return total

def _within_matrix_range(matrix, point):
	if point.x < 0:
		return False
	elif point.x >= len(matrix)
		return False
	elif point.y < 0
	….
elif point.y >=
	….
return True

def _reach_destination(matrix, point):
	return (
point.x == len(matrix)-1 and 
point.y == len(matrix[0])-1
)
