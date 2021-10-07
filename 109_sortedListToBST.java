// medium
// binary tree + linked list

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        // basically just keep inserting linked list node into the BST
        // and this BST is self-balancing

        TreeNode res = null;
        while (head != null) {
            res = insert(res, head.val);
            head = head.next;
        }
        return res;
    }
    
    public TreeNode insert(TreeNode tree, int v) {
        if (tree == null) return new TreeNode(v);
        if (v > tree.val) tree.right = insert(tree.right, v);
        if (v < tree.val) tree.left = insert(tree.left, v);
        
        
        // balance the tree
        int bal = TreeHeight(tree.left) - TreeHeight(tree.right);
        if (bal > 1) {
            // left side too heavy
            // rotate to right
            if (v < tree.left.val) {
                tree = right_rotate(tree);
            } else {
                tree.left = left_rotate(tree.left);
                tree = right_rotate(tree);
            }
        } else if (bal < -1) {
            // right side too heavy
            // rotate to left
            if (v > tree.right.val) {
                tree = left_rotate(tree);
            } else {
                tree.right = right_rotate(tree.right);
                tree = left_rotate(tree);
            }
        }
        return tree;
    }
    
    public int TreeHeight(TreeNode tree) {
        if (tree == null) return 0;
        int left = TreeHeight(tree.left);
        int right = TreeHeight(tree.right);
        return left > right ? left + 1 : right + 1; 
    }
    
    public TreeNode left_rotate(TreeNode tree) {
        TreeNode right_left = tree.right.left;
        TreeNode right = tree.right;
        right.left = tree;
        tree.right = right_left;
        return right;
    }
    
    public TreeNode right_rotate(TreeNode tree) {
        TreeNode left_right = tree.left.right;
        TreeNode left = tree.left;
        tree.left = left_right;
        left.right = tree;
        return left;
        
    }
}