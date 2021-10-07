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
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        /*
            prev -- previous node of cur
            tail -- node at position left
            con -- node at postion (left - 1)
            third -- cur.next
        */
        ListNode cur = head, prev = null, tail = null, con = null, third = null;
        if (left == 1) con = head;
        for (int i = 1; i <= right; i++) {
            if (left > 1 && i == left - 1) con = cur;
            if (i == left) tail = cur;
            if (i >= left && i <= right) {
                third = cur.next;
                cur.next = prev;
                prev = cur;
                cur = third;
            } else {
                prev = cur;
                cur = cur.next;
            }    
        }
        
        /*
            By the end of the for loop
                cur -- node at posiion (right + 1)
                prev -- node at position right
                tail -- node at position left
                con -- node at postion (left - 1)
        */
        
        tail.next = cur;
        // if we need to reverse head node as well
        // then the new head will the node at position right
        if (left != 1) con.next = prev;
        else head = prev;
        return head;
    }
}