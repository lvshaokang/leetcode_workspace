//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1129 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 抽象为模型:   可行
     *  0-1背包问题,是否能装满背包
     *
     * sum/2
     * 两个等和子集 等价于 拿nums[]中的物品,能否装满一个子集,如果可以装满一个子集,那么两个子集的和一定相等
     *
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        // 如果sum%2=奇数时,一定装不满
        if (sum % 2 == 1) return false;
        sum /= 2;

        boolean[][] dp = new boolean[n][sum + 1];
        dp[0][0] = true;
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
