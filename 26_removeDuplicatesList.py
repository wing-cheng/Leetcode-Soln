# easy
# array

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        
        prev = nums[0]
        mv = 1
        for i in range(1, len(nums)):
            if prev != nums[i]:
                prev = nums[i]
                nums[mv] = prev
                mv += 1
                
        return mv