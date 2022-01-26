//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 86 👎 0


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
    private boolean comming = false;
    private TreeNode successor = null; // 记录中序后继节点

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        return successor;
    }

    /**
     * 返回值并非要求解的值
     * 要求解的值放在全局变量中
     */
    public void inorder(TreeNode node, TreeNode p) {
        if (node == null) return;
        inorder(node.left, p);

        if (successor != null) return; // 找到了，直接返回
        if (comming == true) { // 递归找下一个节点,方法就要写到上面
            successor = node;
            comming = false;
            return;
        }

        if (node == p) comming = true;

        inorder(node.right, p);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
