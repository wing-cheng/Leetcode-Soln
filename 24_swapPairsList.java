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
    public ListNode swapPairs(ListNode head) {
        
        // if empty list or list with one node
        if (head == null || head.next == null) return head;

        ListNode first = head, second = head.next, temp_next, res = second, temp_prev = null;
        while (second != null) {
            // keep the head of next pair
            temp_next = second.next;
            // start the swap
            second.next = first;
            first.next = temp_next;
            if (temp_prev != null) temp_prev.next = second;
            // keep the tail of current pair
            temp_prev = first;
            // advance to the next pair
            first = temp_next;
            if (first != null) second = first.next;
            else break;
        }
        return res;
    }
}