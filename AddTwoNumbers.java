/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode curr = null, prev = null, rem = null;
        int sum = 0, carry = 0;
        
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum/10;
            if (l3 == null) {
                l3 = new ListNode(sum%10);
                prev = l3;
            } else {
                curr = new ListNode(sum%10);
                prev.next = curr;
                prev = curr;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 != null) {
            rem = l1;
        } else if (l2 != null) {
            rem = l2;
        }
        
       while (rem != null) {
           sum = rem.val + carry;
           carry = sum/10;
           curr = new ListNode(sum%10);
           prev.next = curr;
           prev = curr;
           rem = rem.next;
       }
        
        if (carry != 0) {
            curr = new ListNode(carry);
            prev.next = curr;
        }
        
        return l3;
    }
}