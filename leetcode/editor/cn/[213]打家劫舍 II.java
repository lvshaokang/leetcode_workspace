//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 927 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 分别处理两种决策
     *  第0个偷,那么第1个不偷,第n-1个不偷,第2个可偷可不偷,第n-2个可偷可不偷
     *  第0个不偷,那么第1个可偷可不偷,第n-1个可偷可不偷
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // 第0个不偷,偷1~n-1之间的房子
        int maxValue1 = rob_dp(nums, 1, n - 1);
        // 第0个偷,偷2~n-2之间的房子
        int maxValue2 = rob_dp(nums, 2, n - 2) + nums[0];

        return Math.max(maxValue1, maxValue2);
    }

    private int rob_dp(int[] nums, int p, int r) {
        int n = nums.length;
        // dp[i][0]表示第i个物品没有选时的最大金额
        // dp[i][1]表示第i个物品选择时的最大金额
        int[][] dp = new int[n][2];
        dp[p][0] = 0;
        dp[p][1] = nums[p];
        for (int i = p + 1; i <= r; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[r][0], dp[r][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
