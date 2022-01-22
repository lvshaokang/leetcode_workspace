//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 862 👎 0


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
     * merge(t1, t2) = merge(t1.left,t2.left) + merge(t1.right,t2.right) + merge root
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2; // t1==null,直接返回t2(不空的树)
        if (t2 == null) return t1;

        TreeNode treeNode = new TreeNode(t1.val + t2.val); // root节点val相加
        TreeNode leftRoot = mergeTrees(t1.left, t2.left); // 合并左子树,返回左子树的root节点
        TreeNode rightRoot = mergeTrees(t1.right, t2.right); // 合并右子树,返回右子树的root节点
        // 拼接root、左子树、右子树
        treeNode.left = leftRoot;
        treeNode.right = rightRoot;
        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
