class Solution:
    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        result = []
        self._find_queens(queens, king, self._right, result)
        self._find_queens(queens, king, self._right_down, result)
        self._find_queens(queens, king, self._down, result)
        self._find_queens(queens, king, self._left_down, result)
        self._find_queens(queens, king, self._left, result)
        self._find_queens(queens, king, self._left_up, result)
        self._find_queens(queens, king, self._up, result)
        self._find_queens(queens, king, self._right_up, result)
        return result
    
    def _find_queens(self, queens: List[List[int]], position: List[int], go, output: List[List[int]]):
        if position in queens:
            output.append(position)
        else:
            if self._is_valid(go(position)):
                self._find_queens(queens, go(position), go, output)
    
    def _left(self, position: List[int]) -> List[int]:
        return [position[0], position[1]-1]
    
    def _right(self, position: List[int]) -> List[int]:
        return [position[0], position[1]+1]
    
    def _up(self, position: List[int]) -> List[int]:
        return [position[0]-1, position[1]]
    
    def _down(self, position: List[int]) -> List[int]:
        return [position[0]+1, position[1]]
    
    def _left_up(self, position: List[int]) -> List[int]:
        return [position[0]-1, position[1]-1]
    
    def _left_down(self, position: List[int]) -> List[int]:
        return [position[0]+1, position[1]-1]
    
    def _right_up(self, position: List[int]) -> List[int]:
        return [position[0]-1, position[1]+1]
    
    def _right_down(self, position: List[int]) -> List[int]:
        return [position[0]+1, position[1]+1]
    
    def _is_valid(self, position: List[int]):
        return position[0] >= 0 and position[0] < 8 and position[1] >= 0 and position[1] < 8
    