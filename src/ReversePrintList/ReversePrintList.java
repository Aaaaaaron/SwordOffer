package ReversePrintList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Melody on 2016/9/10.
 */
public class ReversePrintList {
    public static void main ( String[] args ) {
        ListNode headNode = new ListNode();
        ListNode secondNode = new ListNode();
        ListNode thirdNode = new ListNode();
        headNode.value = 1;
        headNode.next = secondNode;
        secondNode.value = 2;
        secondNode.next = thirdNode;
        thirdNode.value = 3;
        thirdNode.next = null;
        //reversePrintList( headNode );
        printListFromTailToHead( headNode );
    }


    //递归版本
    public static void printListFromTailToHead ( ListNode listNode ) {
        List list = new ArrayList();
        if ( listNode != null ) {
            printListFromTailToHead( listNode.next );
            System.out.println( listNode.value );
        }
    }

    //非递归版本
    public static void reversePrintList ( ListNode node ) {
        Stack result = new Stack();
        while ( node != null ) {
            result.push( node.value );
            node = node.next;
        }
        while ( !result.isEmpty() ) {
            System.out.println( result.pop() );
        }
    }

    static class ListNode {
        int value;
        ListNode next = null;
    }
}
