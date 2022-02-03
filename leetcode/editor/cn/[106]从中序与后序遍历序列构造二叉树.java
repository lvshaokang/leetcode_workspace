//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 664 👎 0


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return doBuildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode doBuildTree(int[] postorder, int i, int j, int[] inorder, int p, int r) {
        if (i > j) return null;

        TreeNode root = new TreeNode(postorder[j]);
        // 在中序遍历结果inorder中,查询postorder[j]所在的位置q
        // [p,q-1] q [q+1,r]
        int q = p;
        while (inorder[q] != postorder[j]) {
            q++;
        }
        int leftTreeSize = q - p; // 左右子树大小
        // 构建左子树
        TreeNode leftNode = doBuildTree(postorder, i, i + leftTreeSize - 1, inorder, p, q - 1);
        // 构建右子树
        TreeNode rightNode = doBuildTree(postorder, i + leftTreeSize, j - 1, inorder, q + 1, r);
        // 根据root、左子树、右子树构建树 [i, j-1]
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
