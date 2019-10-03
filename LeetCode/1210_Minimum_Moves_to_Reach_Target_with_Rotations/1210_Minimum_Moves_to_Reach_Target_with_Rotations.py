class Solution(object):
    
    def minimumMoves(self, grid):
        
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        visited = set()
        link_to_parents = dict()
        start = (0, 0, 0, 1)
        link_to_parents[start] = None
        import Queue
        q = Queue.Queue()
        q.put(start)
        visited.add(start)
        while not q.empty():
            point = q.get()
            rotate_point = (-1, -1, -1, -1)
            if _is_horizon(point):
                right = _hright(point)
                if right not in visited and _is_valid(right, grid): 
                    _record(visited, link_to_parents, q, right, point)
                down = _hdown(point)
                if down not in visited and _is_valid(down, grid):
                    _record(visited, link_to_parents, q, down, point)
                if _can_rotate_clock_wise(point, grid):
                    rotate_point = _clock_wise_rotate(point)
                    if rotate_point not in visited:
                        _record(visited, link_to_parents, q, rotate_point, point)
            else:
                right = _vright(point)
                if right not in visited and _is_valid(right, grid):
                    _record(visited, link_to_parents, q, right, point)
                down = _vdown(point)
                if down not in visited and _is_valid(down, grid):
                    _record(visited, link_to_parents, q, down, point)
                if _can_rotate_counter_clock_wise(point, grid):
                    rotate_point = _counter_clock_wise(point)
                    if rotate_point not in visited:
                        _record(visited, link_to_parents, q, rotate_point, point)
            if _reach_destination(right, down, rotate_point, grid):                
                break
        
        if q.empty():
            return -1
        
        steps = _total_steps(link_to_parents, grid)
        return steps
            
def _is_horizon(point):
    return point[0] == point[2] and point[1]+1 == point[3]

def _is_valid(point, grid):
    l = len(grid)
    def is_within_range(x):
        return x >= 0 and x < l

    valid = (
        is_within_range(point[0]) and
        is_within_range(point[1]) and
        is_within_range(point[2]) and
        is_within_range(point[3])
    )

    return (
        valid and 
        grid[point[0]][point[1]] == 0 and
        grid[point[2]][point[3]] == 0
    )
            
def _hright(point):
    return (point[2], point[3], point[2], point[3]+1)

def _hdown(point):
    return (point[0]+1, point[1], point[2]+1, point[3])

def _record(visited, link_to_parents, q, forward, point):
    visited.add(forward)
    link_to_parents[forward] = point
    q.put(forward)

def _can_rotate_clock_wise(point, grid):
    down = _hdown(point)
    return _is_valid(down, grid)

def _clock_wise_rotate(point):
    return (point[0], point[1], point[0]+1, point[1])

def _vdown(point):
    return (point[2], point[3], point[2]+1, point[3])

def _vright(point):
    return (point[0], point[1]+1, point[2], point[3]+1)

def _can_rotate_counter_clock_wise(point, grid):
    right = _vright(point)
    return _is_valid(right, grid)

def _counter_clock_wise(point):
    return (point[0], point[1], point[0], point[1]+1)

def _reach_destination(right, down, rotate_point, grid):
    l = len(grid)
    dest = _destination(l)
    def is_destination(point):
        return dest == point

    return (
        is_destination(right) or
        is_destination(down) or
        is_destination(rotate_point)
    )

def _destination(l):
    return (l-1, l-2, l-1, l-1)

def _total_steps(link_to_parents, grid):
    n = len(grid)
    dest = _destination(n)
    count = 0
    while link_to_parents[dest] is not None:
        dest = link_to_parents[dest]
        count += 1
    return count
    