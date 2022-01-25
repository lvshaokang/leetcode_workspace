//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1388 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 返回值并非要求解的值
     * 要求解的值放在全局变量中
     */
    private boolean isValid = true;
    /**
     * 问题转化成: 获取二叉树的最大值、最小值 —> 适合用递归来实现
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        dfs(root);
        return isValid;
    }

    private int[] dfs(TreeNode root) {
        int min = root.val; // 初始化min/max,避免左右子树为空的情况
        int max = root.val;
        if (root.left != null) {
            int[] leftMinMax = dfs(root.left);
            if (isValid == false) return null; // 提前退出条件
            if (leftMinMax[1] >= root.val) { // 左子树的max > root.val,不是二叉搜索树
                isValid = false;
                return null;
            }
            min = leftMinMax[0]; // 更新left的min
        }
        if (root.right != null) {
            int[] rightMinMax = dfs(root.right);
            if (isValid == false) return null; // 提前退出条件
            if (rightMinMax[0] <= root.val) { // 右子树的min < root.val,不是二叉搜索树
                isValid = false;
                return null;
            }
            max = rightMinMax[1]; // 更新right的max
        }
        return new int[] {min, max};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
