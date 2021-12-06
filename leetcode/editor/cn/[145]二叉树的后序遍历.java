//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 719 👎 0


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

    private class SFrame {
        private int status;
        private TreeNode node = null;
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
    public List<Integer> postorderTraversal(TreeNode root) {
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
                stack.peek().status = 3;
                if (stack.peek().node.right != null) {
                    stack.push(new SFrame(1, stack.peek().node.right));
                }
                continue;
            }
            if (stack.peek().status == 3) {
                result.add(stack.peek().node.val);
                stack.pop();
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
