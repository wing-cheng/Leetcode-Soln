# easy
# linked list

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        prev = {}
        
        i = 0
        while i < len(nums):
            diff = target - nums[i]
            
            if diff in prev.keys():
                return [prev[diff], i]
            
            prev[nums[i]] = i
            i += 1