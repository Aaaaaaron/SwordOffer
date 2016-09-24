package Fibonacci;

/**
 * 太多重复计算 比如f(10)要计算f(9)和f(8),他们都要计算f(7)以下的f()
 */
public class FibonacciRecursive {
    public static void main ( String[] args ) {
        System.out.println( fibonacci( 10 ) );
    }
    public static int fibonacci ( int n ) {
        if ( n <= 0 )
            return 0;
        if (n == 1 )
            return 1;
        return fibonacci( n - 1 ) + fibonacci( n - 2 );
    }
}
