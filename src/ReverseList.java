/**
 * 反转链表
 */
public class ReverseList {
    public static void main(String args[])
    {
        ListNode head=new ListNode();
        ListNode second=new ListNode();
        ListNode third=new ListNode();
        ListNode forth=new ListNode();
        head.next=second;
        second.next=third;
        third.next=forth;
        head.val=1;
        second.val=2;
        third.val=3;
        forth.val=4;
        ReverseList test=new ReverseList();
        ListNode resultListNode=test.reverseList(head);
        while ( resultListNode != null ) {
            System.out.println( resultListNode.val );
            resultListNode = resultListNode.next;
        }
    }

    public ListNode reverseList ( ListNode head ) {
        if ( head == null || head.next == null )
            return head;
        ListNode resverNode = reverseList( head.next );

        head.next.next = head;
        head.next = null;
        return resverNode;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode () {
        }

        ListNode ( int val ) {
            this.val = val;
        }
    }
}
