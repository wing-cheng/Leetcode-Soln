// medium
// linked list


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
        
        // if empty list
        if (head == null) return null;
        
        ListNode dummy = new ListNode(-1, head);
        ListNode first = dummy, second = dummy;
        for (int i = 0; i < n+1; i++) {
            first = first.next;
        }
        // now first and second pointer are n nodes apart
        // move them all together
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // now delete the node
        // if second is the dummy node
        if (second.val == -1) return head.next;
        if (second != null) second.next = second.next.next;
        return head;
    }
}