// easy
// array

class Solution {
    public int removeElement(int[] nums, int val) {
        int l = nums.length;
        int i = 0;
        while (i < l) {
            if (nums[i] == val) {
                nums[i] = nums[l-1];
                l--;
            } else {
                i++;
            }
        }
        return l;
    }
}