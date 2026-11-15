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
        int k=0,p;
        ListNode head1 = head;
        while(head1 != null){
            k++;
            head1 = head1.next;
        }
        p = k-n+1;

        if(p == 1){
            return head.next;
        }
        
        ListNode temp = head;
        for(int i=1 ;i < p-1;i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        
        return head;

    }
}