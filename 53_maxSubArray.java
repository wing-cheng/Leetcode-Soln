// easy
// array



class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sum = 0;
        int max_sum = nums[0];
        for (int i = 0; i < nums.length; i++) { // row
            if (curr_sum < 0) {
                curr_sum = 0;
            }      
            curr_sum += nums[i];
            max_sum = curr_sum > max_sum ? curr_sum : max_sum;
        }
        return max_sum;
    }
}