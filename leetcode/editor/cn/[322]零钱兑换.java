//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 1714 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 抽象为模型:   最值
     *  完全背包问题,装满背包的最少硬币数
     *
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (n == 0) return -1;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int c = 0; c <= amount / coins[0]; c++) {
            dp[0][c * coins[0]] = c;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount ; j++) {
                int k = j / coins[i];
                for (int c = 0; c <= k; c++) {
                    if (dp[i-1][j - c * coins[i]] != Integer.MAX_VALUE
                    && dp[i-1][j - c * coins[i]] + c < dp[i][j]) {
                        dp[i][j] = dp[i-1][j - c * coins[i]] + c;
                    }
                }
            }
        }
        return dp[n-1][amount] != Integer.MAX_VALUE ? dp[n-1][amount] : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
