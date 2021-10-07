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
    public ListNode rotateRight(ListNode head, int k) {
        // if empty list
        if (head == null || head.next == null || k == 0) return head;
        
        // can my algo handle list with one node?
        ListNode temp = head;
        ListNode prev = head, new_head = null;
        int len = 1;
        while (prev.next != null) {
            prev = prev.next;
            len++;
        }
        
        if (k % len == 0) return head;
        k %= len;
        
        
        for (int i = 1; i < len - k; i++) temp = temp.next;
        
        new_head = temp.next;
        temp.next = null;
        prev.next = head;
        
        return new_head;
    }
}