//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1404 👎 0


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * preorder下标 i,j
     * inorder下标 p,r
     */
    public TreeNode doBuildTree(int[] preorder, int i, int j, int[] inorder, int p, int r) {
        if (i > j) return null;

        TreeNode root = new TreeNode(preorder[i]);
        // 在中序遍历结果inorder中,查询preorder[i]所在的位置q
        // [p,q-1] q [q+1,r]
        int q = p;
        while (inorder[q] != preorder[i]) {
            q++;
        }
        int leftTreeSize = q - p; // 左右子树大小
        // 构建左子树
        TreeNode leftNode = doBuildTree(preorder, i + 1, i + leftTreeSize, inorder, p, q - 1);
        // 构建右子树
        TreeNode rightNode = doBuildTree(preorder, i + leftTreeSize + 1, j, inorder, q + 1, r);
        // 根据root、左子树、右子树构建树 [i+1, j]
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
