//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1152 👎 0


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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        // 定位prev节点
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        /*
         * 使用头插法,反转指定区域的链表
         * 1 -> 2 -> 3 -> 4 -> 5
         * cur -> 2, 1 -> prev, 3 -> next
         *
         * 1 -> 3 -> 2 -> 4 -> 5
         *
         */
        ListNode cur = prev.next; // cur 待操作节点
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next; // 暂存 next 节点 3
            cur.next = next.next; // 2 -> 4
            next.next = prev.next; // 3 -> 2
            prev.next = next; // 1 -> 3
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
