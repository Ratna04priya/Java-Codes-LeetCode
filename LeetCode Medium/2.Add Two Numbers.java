// 2. Add Two Numbers
//By Ratna Priya

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
        int carry =0;
        int sum=0;
        ListNode res = new ListNode(-1);
        ListNode head = res;
        if(l1 == null && l2 == null){
            return null;
        }
        else if(l1 == null && l2 != null) {
            return l2;
            
        }
         else if(l1 != null && l2== null) {
            return l1;
            
        }
        else{
            while(l1 != null || l2 != null){
                // if(l1 == null) l1.val =0;
                // if(l2 == null) l2.val =0;
            if(l1 == null){
                sum = l2.val+carry;
            }
            else if(l2 == null){
                sum = l1.val+carry;
            }
            else{
                 sum = l1.val +l2.val+carry;
            }
           
            carry = sum/10;
            sum = sum%10;
            head.next = new ListNode(sum);
            head = head.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null)l2 = l2.next;
            }
        }
        if(carry != 0){
            head.next = new ListNode(carry);
        }
        return res.next;
    }
}
