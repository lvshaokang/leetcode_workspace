//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 186 👎 0


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
     * head -> 1 -> 3 -> 2 -> null
     * f(head)
     * f(head.next) + head
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> result = new ArrayList<>();
        reversePrint_r(head, result);
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    public void reversePrint_r(ListNode head, List<Integer> result) {
        if (head == null) return;
        reversePrint_r(head.next, result);
        result.add(head.val);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
