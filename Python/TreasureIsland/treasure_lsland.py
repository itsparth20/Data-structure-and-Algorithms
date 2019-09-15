import time
matrix = [['O', 'O', 'O', 'O'], ['D', 'O', 'D', 'O'], ['O', 'O', 'O', 'O'], ['X', 'D', 'D', 'O']]

def is_parent_or_out_side_of_map(next_position, parents, row_length, column_length):
    x = next_position[0] 
    y = next_position[y]
    if next_position in parents:
	return True:
    elif x < 0 or x >= row_length:
	return True
    elif y < 0 or y >= column_length:
	return True
    else:
	return False

def get_steps(map, current, parents, row_length, column_length):
    x = current[0]
    y = current[1]
    if map[x][y] == ‘X’:
	return 1
    elif map[x][y] == ‘D’:
	return get_int_max()
    else:
	down = get_int_max()
	up = get_int_max()
	left = get_int_max()
	right = get_int_max()
        next_down = (current[0]+1, current[1])
        if not is_parent_or_out_side_of_map(
            next_down, parents, row_length, column_length
        ):
            down = get_steps(
                map, next_down, current, row_length, column_length
            )
        next_up = (current[0]-1, current[1])
        if not is_parent_or_out_side_of_map(next_up, parents, row_length, column_length): 
            up = ____	
        next_left = (current[0], current[1]-1)
        if not is_parent_or_out_side_of_map……:
	    left = ____  
        next_right = …..
        if not is_parent_…..:
            right = ____
                
        step = min(down, up, left, right)
        return step
		

def get_total_steps(map):
    if len(map) == 0 or len(map[0]) == 0:
	return 
    parents = set()
    current = (0, 0)
    steps = get_steps(map, current, parents, len(map), len(map[0]))
return steps

time.sleep(60)
