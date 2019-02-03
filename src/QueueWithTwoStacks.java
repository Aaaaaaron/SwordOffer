import java.util.Stack;

/**
 * Created by Melody on 2016/9/11.
 */
public class QueueWithTwoStacks {
    public static void main ( String[] args ) {
        QueueWithTwoStacks test = new QueueWithTwoStacks();
        test.push( 1 );
        test.push( 2 );
        test.push( 3 );
        test.push( 4 );
        System.out.println( test.pop() );
        System.out.println( test.pop() );
        System.out.println( test.pop() );
        System.out.println( test.pop() );
        System.out.println( test.pop() );
    }

    private Stack< Integer > stack1 = new Stack<>();
    private Stack< Integer > stack2 = new Stack<>();

    public void push ( int node ) {
        stack1.push( node );
    }

    public Integer pop () {
        if ( stack2.isEmpty() ) {
            if ( stack1.isEmpty() )
                return null;
            while ( !stack1.isEmpty() ) {
                stack2.push( stack1.pop() );
            }
        }
        return stack2.pop();
    }
}
