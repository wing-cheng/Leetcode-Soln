"""
    :type nums: List[int]
    :type k: int
    :rtype: None Do not return anything, modify nums in-place instead.

    [1,2,3,4,5,6,7] curr = 5, count = 0, prev = 6  write to curr+k
    [6,2,3,4,5,6,7] curr = 6, count = 1, prev = 1
    [6,2,1,4,5,6,7] curr = 0, count = 1, prev = 3
    [6,2,3,4,5,6,7] curr = 6, count = 1, prev = 1
    res [6,7,1,2,3,4,5]
"""

class Solution(object):
    def rotate(self, nums, k):
        n = len(nums)
        if k % n == 0:
            return
        k = k % n
        to_mv, res = nums[((-1)*k):], nums[:len(nums)-k]
        to_mv.extend(res)
        # print(to_mv, res)
        return to_mv

    def rotate2(self, nums, k):
        n = len(nums)
        if k % n == 0:
            return
        k = k % n
        curr = n - k
        prev = nums[curr]
        # tmp = nums[curr]
        count = 0
        while count <= n:
            nums[(curr + k) % n], prev = prev, nums[(curr + k) % n]
            curr += 1
            curr %= n
            count += 1                        



# testing

lst = [1,2,3,4,5,6,7]
soln = Solution()
    
print(f"rotate 1 : {soln.rotate2(lst, 1)}")
print(f"rotate 2 : {soln.rotate2(lst, 2)}")
print(f"rotate 3 : {soln.rotate2(lst, 3)}")