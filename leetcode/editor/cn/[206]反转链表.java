//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2054 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 头插
     * 看是否需要虚拟头结点
     *  结果链表为空链表(newhead->null)时,是否会有问题
     */
    /*public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null; // 无虚拟头结点
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next; // 因为,结果链表要操作指针p,p.next指针可能丢失,因此暂存p.next
            p.next = newHead; // 第一次遍历, p.next = null, p.next -> Null
            newHead = p; // newHead、p 指针后移
            p = tmp;
        }
        return newHead;
    }*/

    public ListNode reverseList(ListNode head) {
        // 递归终止条件
        if (head == null) {
            return null;
        }
        if (head.next == null) { // 一个节点的情况
            return head;
        }

        // 主体逻辑
        /*
         *                head -> 1 ->
         *                           ↓
         * newhead -> 5 -> 4 -> 3 -> 2 -> null
         */
        ListNode newHead = reverseList(head.next);
        head.next.next = head; // 2 -> head
        head.next = null;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
