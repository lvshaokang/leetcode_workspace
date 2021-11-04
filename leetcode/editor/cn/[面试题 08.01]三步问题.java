//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。 
//
// 示例1: 
//
// 
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 66 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int waysToStep(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return waysToStep(n-3) + waysToStep(n-2) + waysToStep(n-1);
    }*/

    int[] mem;
    public int waysToStep(int n) {
        mem = new int[n + 1];
        return waysToStep_r(n);
    }

    /**
     * 感觉是取模的问题
     */
    public int waysToStep_r(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (mem[n] != 0) {
            return mem[n];
        }
        mem[n] = waysToStep_r(n-3) + waysToStep_r(n-2) + waysToStep_r(n-1);
        return mem[n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
