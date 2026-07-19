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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode curr=head;
        ArrayList<ListNode> arr=new ArrayList<>();

        while(curr!=null){
            arr.add(curr);
            curr=curr.next;
        }
        int l=0;
        int r=arr.size()-1;
        while(l<r){
            arr.get(l).next=arr.get(r);
            l++;

            if(l==r) break;

            arr.get(r).next=arr.get(l);
            r--;
        }
        arr.get(l).next=null;
    }
}