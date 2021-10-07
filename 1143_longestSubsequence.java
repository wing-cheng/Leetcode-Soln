// medium
// dynamic programming


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] resTable = new int[text1.length()+1][text2.length()+1];
        for (int y = 1; y < text1.length()+1; y++) {
            for (int x = 1; x < text2.length()+1; x++) {
                // if same character
                if (text1.charAt(y-1) == text2.charAt(x-1)) {
                    resTable[y][x] = resTable[y-1][x-1] + 1;
                } else {
                    // if different character
                    resTable[y][x] = Math.max(resTable[y-1][x], resTable[y][x-1]);
                }
            }
        }
        return resTable[text1.length()][text2.length()];
    }
}