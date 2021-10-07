// easy
// array

class Solution {
    public int longestPalindrome(String s) {
        
        // make an array that counts the number of ocurrence of each character
        // there are 128 ascii characters
        int[] counts = new int[128];    // default value is 0
        int odd = 0;    // how many odd occurrences
        
        // start counting the occurrence
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        
        for (int v : counts) {
            // we go through each value in 'counts'
            // if there is an odd occurrence we increment odd by 1
            if (v % 2 == 1) odd += 1;
        }
        
        // if there is one odd occurrence then it is okay, we can put the char at the centre
        // we can accept maximum one odd occurrence
        return s.length() - odd + (odd == 0 ? 0 : 1);
    } 
}