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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count =0;
        if(head==null){
            return null;
        }
        
        while(temp!=null){
            count+=1;
            temp=temp.next;
        }
        int x = count - n +1;
        if(x==1){
            return head.next;
        }
        temp = head;
        for(int i =1;i<x-1 && temp!=null;i++){
            temp = temp.next;
        }
        
        if(temp.next!=null){
            temp.next=temp.next.next;
        }
        return head;
    }
}