// easy
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode temp1 = head, temp2 = head.next;
        while (temp1 != null) {
            while (temp2 != null && temp1.val == temp2.val) {
                temp2 = temp2.next;
            }
            temp1.next = temp2;
            temp1 = temp1.next;
        }
        return head;
    }
}