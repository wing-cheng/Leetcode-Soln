'''
    Input: s = "cbbd"
    Output: "bb"

    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.

'''


class Solution(object):
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



soln = Solution()
print(f"cbbd: {soln.longestPalindrome('cbbd')}")
print(f"babad: {soln.longestPalindrome('bbabada')}")