//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 236 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count = 0;
    int result;
    /**
     * 借助二叉搜索树中序遍历结果为有序序列的特点来解题
     * 1.左根右 从小到大排列
     * 2.右根左 从大到小排列
     */
    public int kthLargest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.right, k); // 右
        if (count >= k) return; // 提前终止递归,剪枝(找到之后,只归不递,拦截返回点之后的逻辑)
        count++; // 记录count
        if (count == k) { // count==k,说明是第k大节点
            result = root.val;
            return; // 提前终止递归，剪枝
        }
        inorder(root.left, k); // 左
    }
}
//leetcode submit region end(Prohibit modification and deletion)
