package StackWithMin;

import java.util.Stack;

/**
 * Created by Melody on 2016/9/25.
 */
public class StackWithMin {
    private Stack< Integer > data = new Stack<>();
    private Stack< Integer > supportStack = new Stack<>();

    public static void main ( String[] args ) {
        StackWithMin test = new StackWithMin();
        test.push( 3 );
        test.push( 4 );
        test.push( 2 );
        test.push( 4 );
        test.push( 5 );
        test.push( 6 );
        test.push( 7 );
        System.out.println( test.top() );
        test.pop();
        System.out.println( test.top() );
        System.out.println( test.min() );
    }

    public void push ( int node ) {
        data.push( node );
        if ( supportStack.isEmpty() ) {
            supportStack.push( node );
        }
        else if ( supportStack.peek() > node ) {
            supportStack.push( node );
        }
        else {
            supportStack.push( supportStack.peek() );
        }
    }

    public void pop () {
        if ( !data.isEmpty() && !supportStack.isEmpty() ) {
            data.pop();
            supportStack.pop();
        }
    }

    public int top () {
        return data.peek();
    }

    public int min () {
        return supportStack.peek();
    }
    //public static void main ( String[] args ) {
    //    StackWithMin test = new StackWithMin();
    //    test.push( 1 );
    //    test.push( 2 );
    //    test.push( 3 );
    //    test.push( 4 );
    //    System.out.println( test.pop() );
    //    System.out.println( test.pop() );
    //    System.out.println( test.pop() );
    //    System.out.println( test.pop() );
    //    //System.out.println( test.pop() );
    //}
    //
    //public void push ( int node ) {
    //    new MyStack().push( node );
    //}
    //
    //public int pop () {
    //    return new MyStack().pop();
    //}
    //
    //public int top () {
    //    return new MyStack().top();
    //}
    //
    //public int min () {
    //    return 1;
    //}
    //
    //static class MyStack {
    //    private Node head;
    //    private int length;
    //
    //    public void push ( int val ) {
    //        Node node = new Node();
    //        node.val = val;
    //        node.next = head;
    //        head = node;
    //        length++;
    //    }
    //
    //    public int pop () {
    //        if ( head == null ) {
    //            throw new EmptyStackException();
    //        }
    //        int temp = head.val;
    //        head = head.next;
    //        length--;
    //        return temp;
    //    }
    //
    //    public int top () {
    //        return head.val;
    //    }
    //
    //    static class Node {
    //        int val;
    //        Node next;
    //    }
    //}
}
