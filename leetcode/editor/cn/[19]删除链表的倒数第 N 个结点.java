//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 👍 1635 👎 0


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode fast = head;
        int count = 0;
        while (fast != null) { //
            count++;
            if (count == n) break;
            fast = fast.next;
        }

        if (fast == null) return head;

        ListNode slow = head;
        ListNode prev = null;
        while (fast.next != null) { // 找倒数第k个节点,记录前驱节点
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev == null) { // 处理 head -> 1 -> null 的情况, 头节点情况
            head = head.next;
        } else {
            prev.next = slow.next; // 删除
        }
        return  head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
