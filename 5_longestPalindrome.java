class Solution {
    int lo = 0;
    int maxlen = 0;

    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1 || n == 0) {
            return s;
        }

        int max_len = 1;
        int res_i = 0, res_j = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                String tmp = s.substring(i, j+1);
                if (tmp.equals(reverse(tmp)) && tmp.length() > max_len) {
                    max_len = tmp.length();
                    res_i = i;
                    res_j = j;
                }
            }
            
        }

        if (res_i == 0 && res_j == 0) {
            return s.substring(0, 1);
        }
        return s.substring(res_i, res_j + 1);
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) return s;

        char[] input = s.toCharArray();
        for (int i = 0; i < n; i++) {
            // see how big the palidrome can become if we choose i as centre
            // expand(input, i, i) means i is centre
            // expend(input, i, i+1) means between i and i+1 is the centre
            expand(input, i, i);
            expand(input, i, i+1);
        }
        return s.substring(lo, lo + maxlen);
    }
    private void expand(char[] s, int i, int j) {
        int n = s.length;
        // System.out.println(n);
        while (i >= 0 && j < n && s[i] == s[j] ) {
            i--;
            j++;
        }
        // i = 0, j = 3
        // lo = 1, maxlen = 2, [1:3]
        if (j - i - 1 > maxlen) {
            maxlen = j - i - 1;
            lo = i + 1;
        }
    }

    private static String reverse(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        char tmp;
        int l = 0, r = n - 1;
        for (; l < r; l++, r--) {
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        String res = new String(arr);
        System.out.println(res);
        return res;
    }

    public static void main(String args[]) {
        String s1 = "cbbd";
        System.out.println("cbbd: " + longestPalindrome(s1));
        String s2 = "babada";
        System.out.println("babada: " + longestPalindrome(s2));
    }

}