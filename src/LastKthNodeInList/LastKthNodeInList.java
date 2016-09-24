package LastKthNodeInList;

/**
 * Created by Melody on 2016/9/24.
 */
public class LastKthNodeInList {
    public static void main ( String args[] ) {
        ListNode head = new ListNode( 1 );
        ListNode second = new ListNode( 2 );
        ListNode third = new ListNode( 3 );
        ListNode forth = new ListNode( 4 );
        ListNode fifth = new ListNode( 5 );
        head.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;

        System.out.println( findKthToTail( head, 1 ).val );
    }

    public static ListNode findKthToTail ( ListNode head, int k ) {
        if ( head == null || k <= 0 )
            return null;

        ListNode result = head;
        ListNode kth = head;
        for ( int i = 0 ; i < k ; i++ ) {
            if ( kth.next != null )
                kth = kth.next;
            else
                return null;

        }
        while ( kth != null ) {
            kth = kth.next;
            result = result.next;
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode ( int val ) {
            this.val = val;
        }
    }
}
