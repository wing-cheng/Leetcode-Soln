'''
    Input: s = "cbbd"
    Output: "bb"

    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.

'''


class Solution(object):

    def __init__(self):
        self.lo = 0
        self.maxlen = 0


    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n == 0 or n == 1:
            return s

        # * that's how u make 2D arry properly in Python
        # res = [[0] * n] * n
        res_i, res_j = (0, 0)
        max_len = 1

        for i in range(0, n):
            for j in range(i+1, n):
                tmp = s[i:j+1]
                if tmp == tmp[::-1] and len(tmp) > max_len:
                    max_len = len(tmp)
                    res_i, res_j = (i, j)

        if res_i == 0 and res_j == 0:
            return str(s[0])
        
        return s[res_i:res_j+1]


    def expand(self, s: str, i: int, j: int) -> None:
        while i >= 0 and j < len(s) and s[i] == s[j]:
            i -= 1
            j += 1
        if j - i - 1 > self.maxlen:
            self.maxlen = j - i - 1
            self.o = i + 1


    def longestPalindrome2(self, s: str) -> str:
        n = len(s)
        if n < 2:
            return s

        for i in range(0, n):
            self.expand(s, i, i)
            self.expand(s, i, i+1)

        return s[self.lo:self.lo+self.maxlen]

   



soln = Solution()
print(f"cbbd: {soln.longestPalindrome('cbbd')}")
print(f"babad: {soln.longestPalindrome('babada')}")
print(f"cbbd: {soln.longestPalindrome2('cbbd')}")
print(f"babad: {soln.longestPalindrome2('babada')}")