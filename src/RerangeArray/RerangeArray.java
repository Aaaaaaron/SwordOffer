package RerangeArray;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class RerangeArray {
    public static void main ( String[] args ) {
        int[] array = new int[] { 1 , 2 , 3 , 4 , 5 };
        rerangeArray( array );
        for ( int i : array ) {
            System.out.println( i );
        }
    }

    public static void rerangeArray ( int[] array ) {
        if ( array == null ) {
            return;
        }
        int head = 0;
        int tail = array.length - 1;
        while ( head < tail ) {
            while ( head < tail && isOdd( array[ head ] ) )
                head++;
            while ( head < tail && isEven( array[ tail ] ) )
                tail--;
            exchage( array, head, tail );
        }
    }

    public static boolean isOdd ( int num ) {
        return num % 2 != 0;
    }

    public static boolean isEven ( int num ) {
        return num % 2 == 0;
    }

    public static void exchage ( int[] array, int index1, int index2 ) {
        if ( index1 < index2 ) {
            int temp = array[ index1 ];
            array[ index1 ] = array[ index2 ];
            array[ index2 ] = temp;
        }
    }
}
