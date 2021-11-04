//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 199 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * n阶台阶==>f(n)种走法
     *
     * @param n
     * @return
     */
    /*public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return numWays(n-1) + numWays(n-2);
    }*/

    int mem[];
    public int numWays(int n) {
        mem = new int[n + 1];
        return numWays_r(n);
    }

    public int numWays_r(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (mem[n] != 0) {
            return mem[n];
        }
        mem[n] = (numWays_r(n-1) + numWays_r(n-2)) % 1000000007;
        return mem[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
