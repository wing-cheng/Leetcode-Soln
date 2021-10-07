// easy
// linked list


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    if (l1 == NULL) return l2;
    if (l2 == NULL) return l1;
    
    struct ListNode *res, *temp;
    if (l1->val < l2->val) {
        res = l1;
        l1 = l1->next;
        temp = res;
    } else if (l1->val > l2->val) {
        res = l2;
        l2 = l2->next;
        temp = res;
    } else {
        res = l1;
        l1 = l1->next;
        res->next = l2;
        l2 = l2->next;
        temp = res->next;
    }
    
    
    while (l1 != NULL && l2 != NULL) {
        if (l1->val < l2->val) {
            temp->next = l1;
            l1 = l1->next;
        } else if (l1->val > l2->val) {
            temp->next = l2;
            l2 = l2->next;
        } else {
            temp->next = l1;
            l1 = l1->next;
            temp = temp->next;
            temp->next = l2;
            l2 = l2->next;
        }
        temp = temp->next;
    }
    
    while (l1 != NULL) {
        temp->next = l1;
        l1 = l1->next;
        temp = temp->next;
    }
    while (l2 != NULL) {
        temp->next = l2;
        l2 = l2->next;
        temp = temp->next;
    }
    
    return res;
}