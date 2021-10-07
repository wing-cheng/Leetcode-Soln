# easy
# linked list

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        
        prev = {}
        
        for i, n in enumerate(numbers):
            
            diff = target - n
            
            if diff in prev.keys():
                return [prev[diff] + 1, i + 1]
            prev[n] = i