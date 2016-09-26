package LastKthNodeInList;

/**
 *相关题目 求链表的中间节点,如果是奇数,返回中间,否则两个随便返回.思路,两个指针,一个走一步,一个走两步,当两步的到末尾的时候,一步的就在中间
 *判断是否形成环形链表.也是上面思路,两步的追上一步的是,反之两步的走到末尾则不是环形链表.
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
