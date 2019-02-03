/**
 * Created by Melody on 2016/9/18.
 */
public class QuickSort {
    public static void main ( String[] args ) {
        Integer[] a = new Integer[] { 4 , 2 , 5 , 6 , 2 , 3 , 5 , 6 , 7 , 8 };
        sort( a );
        for ( int i = 0 ; i < a.length ; i++ ) {
            System.out.print( a[ i ] + " " );
        }
    }

    public static void sort ( Comparable[] a ) {
        sort( a, 0, a.length - 1 );
    }

    public static void sort ( Comparable[] a, int low, int high ) {
        if ( low >= high ) {
            return;
        }
        int j = partition( a, low, high );
        sort( a, low, j - 1 );
        sort( a, j + 1, high );
    }

    private static int partition ( Comparable[] a, int low, int high ) {
        int i = low, j = high + 1;
        Comparable v = a[ low ];
        while ( true ) {
            while ( isLess( a[ ++i ], v ) )
                if ( i == high )
                    break;
            while ( isLess( v, a[ --j ] ) )
                if ( j == low )
                    break;
            if ( i >= j )
                break;
            swap( a, i, j );
        }
        swap( a, low, j );
        return j;
    }

    private static boolean isLess ( Comparable v, Comparable w ) {
        return v.compareTo( w ) < 0;
    }

    private static void swap ( Comparable[] a, int i, int j ) {
        Comparable t = a[ i ];
        a[ i ] = a[ j ];
        a[ j ] = t;
    }
}
