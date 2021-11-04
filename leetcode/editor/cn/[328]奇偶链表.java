//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。 
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
// 
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7->1->5->4->NULL 
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
// Related Topics 链表 👍 486 👎 0


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
     * 结果链表、虚拟头结点、尾插tail指针
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenTail = evenHead;
        ListNode p = head;
        int count = 1;
        while(p != null) {
            ListNode tmp = p.next;
            if (count % 2 == 1) { // 奇数
                p.next = null;
                oddTail.next = p;
                oddTail = p;
            } else {
                p.next = null;
                evenTail.next = p;
                evenTail = p;
            }
            count++;
            p = tmp;
        }
        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
