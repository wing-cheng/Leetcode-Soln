// easy
// array


class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int l = nums.length;
        while (i < l && nums[i] < target) {
            i++;
        }
        return i;
    }
}