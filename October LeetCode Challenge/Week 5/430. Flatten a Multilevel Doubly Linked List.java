//430. Flatten a Multilevel Doubly Linked List
//By Ratna Priya

class Solution {
    public static Node ans;
    public static Node help; // used to keep at top of node
    public static void DFS(Node n) {
        if(n==null) {
            return;
        }
        if(ans.val==0) { // if call is 1st time
            ans.val=n.val;
            help=ans;
        } else {
            Node currentNode = new Node();
            currentNode.val=n.val;
            help.next=currentNode;
            currentNode.prev=help;
            help=currentNode; // put help at top
        }
        DFS(n.child); // 1st call child as we have to putchild 1st
        DFS(n.next);
    }
    public Node flatten(Node head) {
        if(head==null) {  // if Node is Empty return
            return head;
        }
        ans=new Node(); // make new
        help=new Node(); // make new
        DFS(head);  // call DFS function
        return ans;
    }
}
