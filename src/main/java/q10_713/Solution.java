package q10_713;

/*
 * https://leetcode.com/contest/leetcode-weekly-contest-55/problems/subarray-product-less-than-k/
 * Hint: Greedy + List
 *
 * 请将代码提交到上面的网址进行测试
 */

public class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0){
            return 0;
        }

        int res = 1;
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < nums.length) {
            res *= nums[j];
            while (res >= k && i <= j) {
                res /= nums[i];
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 5, 10};
        System.out.println(solution.numSubarrayProductLessThanK(arr, 10));
    }
}
