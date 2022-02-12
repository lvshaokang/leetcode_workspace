//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 1039 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 抽象为模型:   计数
     *  0-1背包问题,总重量target,有多少种装法
     *
     *  同时,背包重量在[-1000,1000]范围内,可偏移+1000 转化为 [0,2000] 的背包
     */
    public int findTargetSumWays(int[] nums, int target) {
        if (target > 1000 || target < -1000) return 0;
        int n = nums.length;
        if (n == 0) return 0;
        int offset = 1000;
        int w = 2000;
        int[][] dp = new int[n][w + 1];
        dp[0][offset - nums[0]] += 1;
        dp[0][offset + nums[0]] += 1; // nums=[0],target=0,结果为2

        // dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                // 数组不越界,且在w范围
                if (j - nums[i] >= 0 && j - nums[i] <= w) {
                    dp[i][j] = dp[i-1][j - nums[i]];
                }
                if (j + nums[i] >= 0 && j + nums[i] <= w) {
                    dp[i][j] += dp[i-1][j + nums[i]];
                }
            }
        }

        return dp[n-1][target + offset];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
