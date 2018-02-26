package q13_714;

/*
 *  https://leetcode.com/contest/leetcode-weekly-contest-55/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *  Hint: Greedy
 *
 *  请将代码提交到上面的网址进行测试
 */

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int buy_point = 0;   //买入点
        int sell_point = 0;  //卖出点


        for (int i = 0; i < prices.length - 1; i++) {
            //如果第i天的股价低于先前卖出点的股价， 且 第i+1天的股价比先前设定的买入点高过fee手续费
            //则把第i+1天的股价设为新的卖出点
            if (prices[sell_point] <= prices[i + 1] && prices[i + 1] - prices[buy_point] > fee) {
                sell_point = i + 1;
            }
            //如果第i+1天的股价暴跌，即第i+1天的股价比先前设定的卖出点低fee手续费， 且 买入点不同于卖出点，即表示存在某个卖出点高于买入点
            //则才真正计算盈利
            //即使是1 8 7 6 5 9， 因为8是先前设定的卖出点，遍历到6发现比8低fee，于是计算1买入8卖出
            else if (prices[sell_point] - prices[i + 1] >= fee && buy_point < sell_point) {
                profit += prices[sell_point] - prices[buy_point] - fee;
                buy_point = i + 1;
                sell_point = i + 1;
            }
            //如果第i+1天的股价低于现在设定的买入点
            //则把第i+1天的股价设为新的买入点
            else if (prices[buy_point] > prices[i + 1]) {
                buy_point = i + 1;
                sell_point = i + 1;
            }

        }

        //如果遍历结束了，存在卖出点高于买入点，但没有暴跌的情况，也应该进行一笔交易
        if (buy_point < sell_point) {
            profit += prices[sell_point] - prices[buy_point] - fee;
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 5, 10};
        System.out.println(solution.maxProfit(arr, 2));
    }
}
