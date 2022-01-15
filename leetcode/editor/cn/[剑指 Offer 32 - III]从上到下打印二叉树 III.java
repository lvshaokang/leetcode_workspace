//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 172 👎 0


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
    /*public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            List<Integer> curLevelNodes = new ArrayList<>();
            int curLevelNum = queue.size();
            for (int i = 0; i < curLevelNum; i++) {
                TreeNode treeNode = queue.poll();
                curLevelNodes.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            if (level % 2 == 0) {
                Collections.reverse(curLevelNodes);
            }
            result.add(curLevelNodes);
            level++;
        }
        return result;
    }*/

    /**
     * turn nodes between 2 stacks
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();

        // init 2 stacks
        Stack<TreeNode>[] stacks = new Stack[2];
        for (int i = 0; i < 2; i++) {
            stacks[i] = new Stack<TreeNode>();
        }
        int turn = 0;
        stacks[turn].add(root);
        while (!stacks[turn].isEmpty()) {
            List<Integer> curLevelNodes = new ArrayList<>();
            while (!stacks[turn].isEmpty()) {
                TreeNode treeNode = stacks[turn].pop();
                curLevelNodes.add(treeNode.val);
                if (turn == 0) { // left -> right
                    if (treeNode.left != null) {
                        stacks[1].push(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        stacks[1].push(treeNode.right);
                    }
                } else { // right -> left
                    if (treeNode.right != null) {
                        stacks[0].push(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        stacks[0].push(treeNode.left);
                    }
                }
            }
            result.add(curLevelNodes);
            turn = (turn + 1) % 2; // update turn
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
