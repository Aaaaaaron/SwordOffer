/**
 * 对年龄排序,由于排序的年龄范围很小,再利用O(n)的辅助空间 这是更合适的排序方法
 */
public class SortAge {
    public static void main ( String[] args ) {
        int[] ages = new int[] { 45 , 39 , 20 , 45 , 39 , 20 , 20 , 20 , 20 };
        sortAge( ages );
        for ( int age : ages ) {
            System.out.print( age );
        }
    }

    public static void sortAge ( int[] ages ) {
        if ( ages == null )
            return;
        int oldestAge = 99;
        int[] timesOfAge = new int[ oldestAge ];
        for ( int age : ages ) {
            if ( age < 0 || age > oldestAge )
                System.out.println( "非法的年龄输入" );

            ++timesOfAge[ age ];
        }

        for ( int i = 0, index = 0 ; i < timesOfAge.length ; i++ )
            for ( int j = 0 ; j < timesOfAge[ i ] ; j++, index++ )
                ages[ index ] = i;
    }
}
