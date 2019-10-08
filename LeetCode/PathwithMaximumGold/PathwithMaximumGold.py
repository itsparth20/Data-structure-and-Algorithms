class Solution(object):
    def getMaximumGold(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        max_value = 0
        for row in range(0, len(grid)):
            for col in range(0, len(grid[0])):
                temp = 0
                if grid[row][col] != 0:
                    visited = set()
                    temp = self._get_gold(grid, row, col, visited)                    
                    max_value = max(max_value, temp)
                    
        return max_value
    
    def _get_gold(self, grid, row, col, visited):
        
        position = (row, col)
        if not self._is_valid(grid, row, col) or self._is_visited(position, visited) or grid[row][col] == 0:
            return 0
        
        visited.add(position)
        left = self._get_gold(grid, row, col-1, visited)
        right = self._get_gold(grid, row, col+1, visited)
        up = self._get_gold(grid, row-1, col, visited)
        down = self._get_gold(grid, row+1, col, visited)
        visited.remove(position)
        max_gold = max(left, right, up, down) + grid[row][col]
        return max_gold
        
    
    def _is_valid(self, grid, row, col):
        return row >= 0 and row < len(grid) and col >= 0 and col < len(grid[0])
    
    def _is_visited(self, position, visited):
        return position in visited