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
    public ListNode partition(ListNode head, int x) {        
        // partition the given list into 2 lists
        // list 1:
        //      before_head -- keeps track of list 1 head
        //      before-tail -- keeps track of list 1 tail
        // list 2:
        //      after_head -- keeps track of list 2 head
        //      after_tail -- keeps track of list 2 tail
        ListNode before_head = null, before_tail = null; 
        ListNode after_head = null, after_tail = null, temp1 = head;
        while (temp1 != head) {
            if (temp1.val >= x) {
                // add temp1 to list 2
                if (after_head == null) {
                    after_head = temp1;
                    after_tail = temp1;
                } else {
                    after_tail.next = temp1;
                    after_tail = after_tail.next;
                }
            } else {
                // add temp1 to list 1
                if (before_head == null) {
                    before_head = temp1;
                    before_tail = temp1;
                } else {
                    before_tail.next = temp1;
                    before_tail = before_tail.next;
                }
            }
            temp1 = temp1.next;
        }
        
        // attach list 1 and list 2
        // if list 1 is empty, return list 2
        if (after_tail != null) after_tail.next = null;
        if (before_head == null) return after_head;
        // else
        before_tail.next = after_head;
        return before_head;
    }
}
    