//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 链表 二叉树 👍 65 👎 0


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
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 层次遍历 + 二叉树转结果链表
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[0];

        List<ListNode> result = new ArrayList<ListNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            // 为每一层构建结果链表
            ListNode dummyHead = new ListNode(); // 虚拟头结点
            ListNode tail = dummyHead;
            int curLevelNum = queue.size();
            for (int i = 0; i < curLevelNum; i++) {
                TreeNode node = queue.poll();

                tail.next = new ListNode(node.val);
                tail = tail.next;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(dummyHead.next);
        }

        ListNode[] resultArr = new ListNode[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
