//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 👍 222 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 快速求x的n次幂
     *  x^n = x^(n/2) * x^(n/2) 偶数
     *  x^n = x^(n/2) * x^(n/2) * x 奇数, int类型计算n/2时会取整
     *
     *  f(x,n) = f(x,n/2) * f(x,n/2)
     *  f(x,n) = f(x,n/2) * f(x,n/2) * x
     */
    public double myPow(double x, int n) {
        if (n >= 0) {
            return  myPow_r(x, n);
        } else {
            // return 1 / myPow_r(x, -1 * n);
            // x=2,n=-2147483648,n=-2^31, x^(-2^31)
            // 1/2^31 int类型,[-2^31,2^31 - 1],越界
            // 1/(x^(-1*(n+1)) * x) = 1 / x^-n
            return 1 / (myPow_r(x, -1 * (n + 1)) * x );
        }
    }

    public double myPow_r( double x, int n) {
        if (n == 0) return 1;
        double halfPow = myPow_r(x , n / 2);
        if (n % 2 == 1) {
            return halfPow * halfPow * x;
        } else {
            return halfPow * halfPow;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
