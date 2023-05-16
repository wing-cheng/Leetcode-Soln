'''
    The isBadVersion API is already defined for you.
    def isBadVersion(version: int) -> bool:

    Python submission is accepted whereas Java submission is not (time limit exceed)
'''

class Solution:

    def firstBadVersion(self, n: int) -> int:
        lo, hi = 1, n
        while True:
            mid = int((lo + hi) / 2)
            if isBadVersion(mid):
                # if mid is bad version, then first bad is in [1, mid - 1]
                # if mid is bad but not first bad, then we move forward
                if isBadVersion(mid - 1):
                    lo, hi = 1, mid - 1
                else:
                    return mid
            else:
                # if mid is not bad, then first bad is in [mid + 1, hi]
                lo, hi = mid + 1, hi


'''
    below is for testing
'''
def isBadVersion(i: int) -> bool:
    return (i >= 73)


if __name__ == '__main__':
    soln = Solution()
    print(f'the first bad version is {soln.firstBadVersion(1000)}')