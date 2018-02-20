package q10_713;

/*
 * https://leetcode.com/contest/leetcode-weekly-contest-55/problems/subarray-product-less-than-k/
 * Hint: Greedy + List
 *
 * 请将代码提交到上面的网址进行测试
 */

public class Solution {

    //Status: Time Limit Exceeded
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = nums[i];
            int j = i;
            while (res < k) {
                count++;
                if (++j < nums.length){
                    res *= nums[j];
                }
                else {
                    break;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 5, 10};
        System.out.println(solution.numSubarrayProductLessThanK(arr, 10));
    }
}
