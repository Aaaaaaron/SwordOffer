package IsPopOrder;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示压入顺序，判断第二个序列是否为弹出顺序.
 * 假设入栈所有数字均不相等
 */
public class IsPopOrder {
    public static void main ( String[] args ) {
        System.out.println( isPopOrder( new int[] { 1 , 2 , 3 , 4 , 5 }, new int[] { 4 , 5 , 3 , 2 , 1 } ) );
    }

    public static boolean isPopOrder ( int[] pushA, int[] popA ) {
        if ( pushA.length == 0 || popA.length == 0 )
            return false;
        Stack< Integer > supportStack = new Stack<>();
        int popIndex = 0;
        for ( int i = 0 ; i < pushA.length ; i++ ) {
            supportStack.push( pushA[ i ] );
            while ( !supportStack.isEmpty() && supportStack.peek() == popA[ popIndex ] ) {
                supportStack.pop();
                popIndex++;
            }
        }
        return supportStack.isEmpty();
    }
}
