package q9_781;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/contest/weekly-contest-71/problems/rabbits-in-forest/
 * Hint: Greedy
 *
 * 请将代码提交到上面的网址进行测试
 */
public class Solution {
    public int numRabbits(int[] answers) {
        if (answers.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : answers) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }

//        System.out.println(map);

        int result = 0;

        for (int i: map.keySet()) {
            result += (((map.get(i) - 1) / (i + 1)) + 1) * (i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 2};
        System.out.println(solution.numRabbits(arr));
    }
}
