// medium
// dynamic programming

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        // use heap instead of stack, can cause stack overflow in virtual machine
        if (s1.length() + s2.length() != s3.length()) return false;
        
        // now assume the lengths are consistent
        boolean[][] res = new boolean[s1.length()+1][s2.length()+1];
        res[0][0] = true;
        // fill in the 0th column and row
        
        for (int y = 1; y <= s1.length(); y++) {
            // compare only s3 and s1
            // assume s2 is empty string
            res[y][0] = (s3.charAt(y-1) == s1.charAt(y-1) && res[y-1][0]);
        }
        for (int x = 1; x <= s2.length(); x++) {
            // compare s3 and s2
            // assume s1 is empty string
            res[0][x] = (s3.charAt(x-1) == s2.charAt(x-1) && res[0][x-1]);
        }
        
        for (int y = 1; y <= s1.length(); y++) {
            for (int x = 1; x <= s2.length(); x++) {
                // res[y][x] = false;
                if (s3.charAt(x+y-1) == s1.charAt(y-1) && res[y-1][x]) res[y][x] = true;
                if (s3.charAt(x+y-1) == s2.charAt(x-1) && res[y][x-1]) res[y][x] = true;
            }
        }
        return res[s1.length()][s2.length()];
    }
    
}