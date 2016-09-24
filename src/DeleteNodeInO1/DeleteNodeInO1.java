package DeleteNodeInO1;

/**
 * 在O(1)时间删除链表节点
 * 一思考,肯定是从被删除的节点推才能达到O1的复杂度,我们可以很方便的得到被删除的节点i的下一个节点j,把j的内容复制到i,然后删除j
 * 这样就等同于删除了i.要注意的是一个是只有一个节点,一个是要删除的节点是尾节点.时间复杂度 [(n-1)*O(1) + O(n)]/n ~= O(1)
 * 代码还不完美 就是我们假设要删除的节点是在链表中的.
 */
public class DeleteNodeInO1 {
    public static void main ( String args[] ) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        head.next = second;
        second.next = third;
        head.value = 1;
        second.value = 2;
        third.value = 3;
        System.out.println( head.next.next.value );
        deleteNode( head, third );
        System.out.println( head.next.next );
    }

    public static void deleteNode ( ListNode head, ListNode toBeDel ) {
        if ( head == null || toBeDel == null )
            return;//最好是抛出异常 但是牛客上的方法签名动了不能oc
        if ( toBeDel.next != null ) {
            toBeDel.value = toBeDel.next.value;
            toBeDel.next = toBeDel.next.next;
        }
        //链表只有一个节点
        else if ( head == toBeDel ) {
            head = null;
        }
        //要删除的是尾节点
        else {
            ListNode nodeBebore = head;
            while ( nodeBebore.next != toBeDel )
                nodeBebore = nodeBebore.next;
            nodeBebore.next = null;

        }

    }

    static class ListNode {
        int value;
        ListNode next;
    }
}
