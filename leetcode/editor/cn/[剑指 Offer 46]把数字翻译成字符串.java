//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 371 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        if (num <= 9) return 1;
        List<Integer> digitList = new ArrayList<Integer>();
        while (num != 0) {
            digitList.add(num % 10);
            num /= 10;
        }
        int n = digitList.size();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = digitList.get(n - 1 - i);
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        // dp[i]表示digits[0~i-1](长度为i)转化为字母有多少种方法
        // dp[i] = dp[i-1] + dp[i-2](可翻译)
        // dp[i] = dp[i-1] (digits[i-2, i-1] 不可翻译)
        for (int i = 1; i <= n; i++) { // 爬楼梯
            dp[i] = dp[i - 1];
            if (i - 2 >= 0 && isValid(digits[i-2], digits[i-1])) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    private boolean isValid(int a, int b) {
        if (a == 1) return true;
        if (a == 2 && b >= 0 && b <= 5) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
