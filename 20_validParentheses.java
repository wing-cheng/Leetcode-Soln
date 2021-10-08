// easy
// stack

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') stack.push(s.charAt(i));
            
            if ((s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') && stack.empty()) return false;
            
            if (s.charAt(i) == '}' && stack.pop() != '{') return false; 
            if (s.charAt(i) == ']' && stack.pop() != '[') return false; 
            if (s.charAt(i) == ')' && stack.pop() != '(') return false; 
        }
        
        if (stack.empty()) return true;
        return false;
    }
}