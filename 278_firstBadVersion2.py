'''
    The isBadVersion API is already defined for you.
    def isBadVersion(version: int) -> bool:
    
    candidate qn: what if there is no bad version?

'''

class Solution:
    def helper(self, lo: int, hi: int) -> int:
        
        mid = int((lo + hi) / 2)
        # print(f'lo: {lo}  mid: {mid}  hi: {hi}')
        if isBadVersion(mid):
            # if the mid is bad, then first bad is in [lo, mid - 1]
            # if mid is bad but not first bad then we move forward
            if isBadVersion(mid - 1):
                return self.helper(1, mid - 1, n)
            else:
                return mid
        else:
            # if the mid is not bad, then first bad is in [mid + 1, hi]
            return self.helper(mid + 1, hi)

    def firstBadVersion(self, n: int) -> int:
        return self.helper(1, n)


def isBadVersion(n: int) -> bool:
    return (n >= 69)

if __name__ == '__main__':

    soln = Solution()
    print(f'first bad version is {soln.firstBadVersion(100)}')