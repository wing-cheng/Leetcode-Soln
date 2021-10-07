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
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null) return head;
        
        ListNode prev = null, temp1 = head, temp2 = temp1;
        Boolean flag = false;
        while (temp1 != null) {
            temp2 = temp1.next;
            while (temp2 != null && temp2.val == temp1.val) {
                flag = true;
                temp2 = temp2.next;
            }
            if (flag) {
                // change temp1
                temp1 = temp2;
                if (prev != null) {
                    prev.next = temp2;
                } else {
                    head = temp2;
                }
                flag = false;
            } else {
                prev = temp1;
                temp1 = temp1.next;
            }
            
        }
        return head;
    }
}