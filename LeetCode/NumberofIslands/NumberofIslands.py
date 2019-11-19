from typing import Set, Any
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if (i,j) not in visited:                    
                    if grid[i][j] == '1':
                        count += 1
                        self._fill_visited(visited, grid, i, j)
        return count
    
    def _fill_visited(self, visited: Set[Any], grid: List[List[str]], i: int, j: int):
        if i < len(grid) and j < len(grid[0]) and i >= 0 and j >= 0:
            if grid[i][j] == '1' and (i,j) not in visited:                
                visited.add((i,j))
                self._fill_visited(visited, grid, i, j+1)
                self._fill_visited(visited, grid, i+1, j)
                self._fill_visited(visited, grid, i, j-1)
                self._fill_visited(visited, grid, i-1, j)
            
        