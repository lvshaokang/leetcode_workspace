//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1196 👎 0


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

    /*private class SFrame {
        private int status;
        private TreeNode node = null;
        public SFrame(int status, TreeNode node) {
            this.status = status;
            this.node = node;
        }
    }*/

    /*List<Integer> result = new ArrayList<>();*/

    /**
     * status=1,表示要扩展左子树,将左子节点入栈
     * status=2,表示左子树扩展完了,要扩展右子树,将右子节点入栈
     * status=3,表示左右子树都扩展完了,出栈
     */
    /*public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return result;

        Stack<SFrame> stack = new Stack<>();
        stack.push(new SFrame(1, root));
        while (!stack.isEmpty()) {
            if (stack.peek().status == 1) {
                stack.peek().status = 2;
                if (stack.peek().node.left != null) {
                    stack.push(new SFrame(1, stack.peek().node.left));
                }
                continue;
            }
            if (stack.peek().status == 2) {
                result.add(stack.peek().node.val);
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
    }*/

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) { // 模拟递归栈,不断遍历左子树
                stack.push(cur);
                cur = cur.left;
            } else { // 左子树到头了,弹出栈顶元素,记录节点值,遍历右边；重复上述过程
                TreeNode node = stack.pop(); // 弹出栈顶元素
                list.add(node.val);
                if (node.right != null) {
                    cur = node.right;
                }
            }
        }
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
