package Fibonacci;

/**
 * 太多重复计算 比如f(10)要计算f(9)和f(8),他们都要计算f(7)以下的f()
 */
public class FibonacciIterative {
    public static void main ( String[] args ) {
        System.out.println( fibonacci( 10 ) );
    }

    public static int fibonacci ( int n ) {
        int result = 0;
        if ( n <= 0 )
            return 0;
        if ( n == 1 || n == 2 )
            return 1;
        int fibOne = 1;
        int fibTwo= 0;
        int fibResult = 0;
        
        for ( int i = 2 ; i <= n ; i++ ) {
            fibResult = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fibResult;
        }
        return fibResult;
    }
}
