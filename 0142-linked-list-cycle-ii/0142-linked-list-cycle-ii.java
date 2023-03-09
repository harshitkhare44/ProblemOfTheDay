/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
    //   ListNode cur= head;
    //     ListNode fast=head;
    //     boolean check=detect(head,slow,fast);
    //     if(check==false)return null;
    //     slow=head;
    //     System.out.println(fast.val);
    //     while(slow!=fast){
    //         slow=slow.next;
    //         fast=fast.next;
    //     }
    //     return slow;

    // }
    // boolean detect(ListNode head,ListNode slow,ListNode fast){
      
    //     while(slow!=null && fast!=null && fast.next!=null){
    //         if(slow==fast)return true;
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }
    //     return false;
    if(head==null || head.next==null)return null;
    ListNode slow=head;
    ListNode fast=head;
    while(slow!=null && fast!=null && fast.next!=null){
      
        slow=slow.next;
        fast=fast.next.next;
          if(slow==fast)break;
    }
    if(slow==null || fast==null || fast.next==null )return null;
   
    slow=head;
    while(slow!=fast){
        slow=slow.next;
        fast=fast.next;
    }
    return slow;
    }
}