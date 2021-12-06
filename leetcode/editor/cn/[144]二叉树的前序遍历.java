//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 696 👎 0


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
     * 递归
     */
    /*public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList();
        preorderTraversal_r(result, root);
        return result;
    }

    public void preorderTraversal_r(List<Integer> result, TreeNode node) {
        // 递归终止条件
        if (node == null) return;
        result.add(node.val);
        preorderTraversal_r(result, node.left);
        preorderTraversal_r(result, node.right);
    }*/

    /**
     * 遍历
     */
    /*public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }*/

    private class SFrame {
        public int status = 1;
        public TreeNode node = null;
        public SFrame(int status, TreeNode node) {
            this.status = status;
            this.node = node;
        }
    }

    List<Integer> result = new ArrayList<>();

    /**
     * status=1,表示要扩展左子树,将左子节点入栈
     * status=2,表示左子树扩展完了,要扩展右子树,将右子节点入栈
     * status=3,表示左右子树都扩展完了,出栈
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return result;
        Stack<SFrame> stack = new Stack<>();
        stack.push(new SFrame(1, root));
        while (!stack.isEmpty()) {
            if (stack.peek().status == 1) {
                result.add(stack.peek().node.val); // 前序 step1
                stack.peek().status = 2;
                if (stack.peek().node.left != null) {
                    stack.push(new SFrame(1, stack.peek().node.left));
                }
                continue;
            }
            if (stack.peek().status == 2) {
                stack.peek().status = 3;
                if (stack.peek().node.right != null) {
                    stack.push(new SFrame(1, stack.peek().node.right));
                }
                continue;
            }
            if (stack.peek().status == 3) {
                stack.pop();
            }
        }
        return result;
    }



}
//leetcode submit region end(Prohibit modification and deletion)
