//给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。 
//
// 注意 这个数列必须是 严格 递增的。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 
//
// 提示: 
//
// 
//
// 
// 1 <= nums.length <= 2000 
// -10⁶ <= nums[i] <= 10⁶ 
// 
// Related Topics 树状数组 线段树 数组 动态规划 👍 569 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n]; // dp[i]表示下标i结尾的最长递增子序列长度
        int[] count = new int[n]; // count[i]表示下标i结尾的最长递增子序列的个数
        dp[0]  = 1;
        count[0] = 1;
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) { // 找到了新的递增子序列,更新最大长度,个数不变
                        count[i] = count[j];
                        dp[i] = dp[j] + 1;
                    } else if (dp[i] == dp[j] + 1) { // 递增子序列长度没有增加,出现了长度一样的情况,个数增加
                        count[i] += count[j];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (max == dp[i]) {
                ans += count[i];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
