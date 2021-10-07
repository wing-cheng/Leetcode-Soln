// easy
// array


class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 0 || strs.length == 1) return strs[0];
        
        String sub = "";
        Boolean match = true;
        
        // we start with assuming that the longest common prefix has length
        // equal to the the length of the first string
        // gradually shrink down the assumed longest common prefix
        for (int min_len = strs[0].length(); min_len >= 0; min_len--) {
            match = true;
            sub = strs[0].substring(0, min_len);
            for (int i = 1; i < strs.length; i++) {
                // do a match with the second until the last string in 'strs'
                if (strs[i].isEmpty() || !strs[i].matches("^" + sub + ".*$")) {
                    match = false;
                    break;
                }
            }
            if (match) return sub;
        }
        return sub;
    }
}