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
    public ListNode rotateRight(ListNode head, int k) {
        //system.out.print("pen nu bun")
        if(head==null || head.next==null || k==0) return head;

        ListNode tail=head;
        int len=1;
        while(tail.next!=null) {
            tail=tail.next; 
            len++;
        }

        k=k%len;
        if(k==0) return head;

        tail.next=head;

        int stepstonewtail=len-k;
        ListNode newtail=head;
        for(int i=1;i<stepstonewtail;i++){
            newtail=newtail.next;
        }

        ListNode newhead=newtail.next;
        newtail.next=null;

        return newhead;
    }
}