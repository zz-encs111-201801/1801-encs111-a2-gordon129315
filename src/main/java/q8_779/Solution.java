package q8_779;

/*
 * https://leetcode.com/contest/weekly-contest-70/problems/k-th-symbol-in-grammar/
 * Hint: Greedy + Decrease
 *
 * 请将代码提交到上面的网址进行测试
 */

import java.util.LinkedList;

public class Solution {
    public int kthGrammar(int N, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        String str = "0";
        int i = 0;
        int k = K;
        while(k > 1) {
            k = (k + 1) / 2;
            list.add(k);
        }
//        System.out.println(list);
        while (!list.isEmpty()) {
            i = list.removeLast();
//            System.out.println(i);
            str = str.charAt( (i + 1) % 2) == '0' ? "01" : "10";
//            System.out.println(str);
        }
        return Integer.parseInt(str.charAt((K + 1) % 2) +"");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthGrammar(3, 3));
    }
}
