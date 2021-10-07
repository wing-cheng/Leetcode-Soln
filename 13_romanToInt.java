class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> weightMap = new HashMap<Character, Integer>();
        
        weightMap.put('I', 1);
        weightMap.put('V', 5);
        weightMap.put('X', 10);
        weightMap.put('L', 50);
        weightMap.put('C', 100);
        weightMap.put('D', 500);
        weightMap.put('M', 1000);
        
        int res = 0;
        int prev = 0, cur = 0;
        for (int i = 0; i < s.length(); i++) {
            
            cur  = weightMap.get(s.charAt(i));
            if (cur > prev) {
                // since we have added weightMap.get(s.charAt(i-1))
                // in the previous step
                // so we have to substract 2 times 'prev'
                res += cur - 2 * prev;
            } else {
                res += cur;
            }
            prev = cur;
        }
        
        
        return res;
    }
}