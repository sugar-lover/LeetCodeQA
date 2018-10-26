package day1009;

import java.util.Arrays;

/**
 * @author zkr123
 * @version 1.0
 * @ClassName Solution
 * @Description
 * @date 2018/10/9 15:06
 */
public class Solution {
    /*给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    示例 1:
    输入: [7,1,5,3,6,4]
    输出: 7
    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

    示例 2:
    输入: [1,2,3,4,5]
    输出: 4
    解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
    因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

    示例 3:
    输入: [7,6,4,3,1]
    输出: 0
    解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。*/
    /**
     * @Description:
     * @auther: zkr123
     * @date: 15:41 2018/10/9
     * @param: [prices]
     * @return: int
     *
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 保留中间值
        int[] cache = new int[prices.length - 1];
        // 先求出相邻两天的收益
        for (int i = 0; i < prices.length - 1; i++) {
            cache[i] = prices[i + 1] - prices[i];
        }
        // 若相邻两天都是正收益则相加,
        int maxProfit = 0;
        int maxProfitSub = 0;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] >= 0) {
                maxProfitSub += cache[i];
            } else {
                maxProfit = maxProfit > maxProfitSub ? maxProfit : maxProfitSub;
                maxProfitSub = 0;
                continue;
            }
        }
        System.out.println(maxProfit);
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int i = 0;
        int j = prices.length - 1;
        while (true) {
            if (i >= j) {
                return maxProfit;
            }
            maxProfit = prices[j] - prices[i] > maxProfit ? prices[j] - prices[i] : maxProfit;
            if (prices[j - 1] - prices[i] > prices[j] - prices[i + 1]) {
                j--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1,2,11,4,7};
        System.out.println(solution.maxProfit2(prices));
    }
}
