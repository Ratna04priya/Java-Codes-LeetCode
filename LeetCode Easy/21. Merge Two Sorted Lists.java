// 21. Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        while(l1 != null){
            minheap.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            minheap.add(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!minheap.isEmpty()){
            head.next = new ListNode(minheap.remove());
            head = head.next;
        }
        return dummy.next;
    }
}
