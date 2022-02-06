//返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 219 👎 0


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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return doConstructFromPrePost(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode doConstructFromPrePost(int[] preorder, int i, int j, int[] postorder, int p, int r) {
        if (i > j) return null;

        TreeNode root = new TreeNode(preorder[i]);
        if (i == j) return root; // 处理preorder[i + 1]时,可能会数组越界

        // 查询左子树的root节点
        // 在postorder中,查询preorder[i+1]所在的位置q, [p,q] [q+1,r-1] r(root)
        int q = p;
        while (postorder[q] != preorder[i + 1]) {
            q++;
        }
        // 左子树大小
        int leftTreeSize = q - p + 1;
        // 构建左子树
        TreeNode leftNode = doConstructFromPrePost(preorder, i + 1, i + leftTreeSize, postorder, p, q);
        // 构建右子树
        TreeNode rightNode = doConstructFromPrePost(preorder, i + leftTreeSize + 1, j, postorder, q + 1, r - 1);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
