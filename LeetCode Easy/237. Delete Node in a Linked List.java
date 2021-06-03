//237. Delete Node in a Linked List - https://leetcode.com/problems/delete-node-in-a-linked-list/
// By Ratna Priya

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
