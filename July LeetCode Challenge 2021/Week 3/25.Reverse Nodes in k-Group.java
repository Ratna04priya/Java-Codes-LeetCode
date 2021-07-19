// 25. Reverse Nodes in k-Group
//By Ratna Priya

class Solution {

public ListNode reverseKGroup(ListNode head, int k) {
    int length=0;
    ListNode temp=head;
    while(temp !=null){
        length++;
        temp=temp.next;
    }if(length>=k)
        return reverseKGroupUtil(head,k,length);
    return head;
}

static ListNode reverseKGroupUtil(ListNode head, int k,int length){
    int count=0;
    ListNode prev=null,next=null,curr=head;
    if(length<k)
        return head;
    while(curr !=null && count<k){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
        count++;
    }
    if(next !=null){
        length-=k;
        head.next=reverseKGroupUtil(next,k,length);
    }
    return prev;
}

}
