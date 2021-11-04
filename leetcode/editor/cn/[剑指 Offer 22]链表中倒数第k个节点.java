//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 👍 293 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
     * 遍历2次
     */
    /*public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;

        ListNode p = head, q = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }

        int newCount = 0;
        while (q != null) {
            newCount++;
            if (newCount == count - k + 1) {
                break;
            }
            q = q.next;
        }
        return q;
    }*/

    /**
     * 快慢指针
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
