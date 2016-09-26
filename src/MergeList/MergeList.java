package MergeList;

/**
 * 典型的递归,把两个链表中值较小的头结点链接到已经合并之后的链表,后续步骤和前面都是一样的
 */
public class MergeList {
    public static void main ( String[] args ) {
        ListNode head1 = new ListNode();
        ListNode second1 = new ListNode();
        ListNode third1 = new ListNode();

        ListNode head2 = new ListNode();
        ListNode second2 = new ListNode();
        ListNode third2 = new ListNode();
        head1.next = second1;
        second1.next = third1;

        head2.next = second2;
        second2.next = third2;

        head1.val = 1;
        second1.val = 3;
        third1.val = 5;

        head2.val = 2;
        second2.val = 4;
        third2.val = 6;

        //ListNode mergeHead = mergeListRecursive( head1, head2 );
        ListNode mergeHead = mergeListIterative( head1, head2 );
        while ( mergeHead != null ) {
            System.out.println( mergeHead.val );
            mergeHead = mergeHead.next;
        }
    }

    public static ListNode mergeListRecursive ( ListNode headFirst, ListNode headSecond ) {
        if ( headFirst == null )
            return headSecond;
        else if ( headSecond == null )
            return headFirst;
        ListNode mergeHead = null;
        if ( headFirst.val > headSecond.val ) {
            mergeHead = headSecond;
            mergeHead.next = mergeListRecursive( headFirst, headSecond.next );
        }
        else {
            mergeHead = headFirst;
            mergeHead.next = mergeListRecursive( headFirst.next, headSecond );
        }
        return mergeHead;
    }

    public static ListNode mergeListIterative ( ListNode headFirst, ListNode headSecond ) {
        if ( headFirst == null )
            return headSecond;
        else if ( headSecond == null )
            return headFirst;
        //新建一个头节点，用来存合并的链表。
        ListNode head = new ListNode( -1 );
        head.next = null;
        ListNode root = head;
        while ( headFirst != null && headSecond != null ) {
            if ( headFirst.val < headSecond.val ) {
                head.next = headFirst;
                head = headFirst;
                headFirst = headFirst.next;
            }
            else {
                head.next = headSecond;
                head = headSecond;
                headSecond = headSecond.next;
            }
        }
        //把未结束的链表连接到合并后的链表尾部
        if ( headFirst != null ) {
            head.next = headFirst;
        }
        if ( headSecond != null ) {
            head.next = headSecond;
        }
        return root.next;
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
