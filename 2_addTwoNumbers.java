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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (l1 != null && l2 != null) {
            carry = l1.val + l2.val + temp.val;
            temp.val = carry % 10;
            carry /= 10;
            if (l1.next == null && l2.next == null) {
                if (carry != 0) {
                    temp.next = new ListNode(carry);
                    temp = temp.next;
                }
            } else {
                temp.next = new ListNode(carry);
                temp = temp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            carry = l1.val + temp.val;
            temp.val = carry % 10;
            carry /= 10;
            if (l1.next == null && carry != 0) {
                temp.next = new ListNode(carry);
                temp = temp.next;
            } else if (l1.next != null) {
                temp.next = new ListNode(carry);
                temp = temp.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            carry = l2.val + temp.val;
            temp.val = carry % 10;
            carry /= 10;
            if (l2.next == null && carry != 0) {
                temp.next = new ListNode(carry);
                temp = temp.next;
            } else if (l2.next != null) {
                temp.next = new ListNode(carry);
                temp = temp.next;
            }
            l2 = l2.next;
        }
        
        return res;
    }
}