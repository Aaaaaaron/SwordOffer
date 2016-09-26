package PrintMatrixInCircle;

/**
 * 魔方翻转 这个思路java静态语言实现太痛苦了
 * String[] arr = {"1","2","3"};
 * Arrays.asList(arr).toString();
 */
public class PrintMatrixInCircle {
    public static void main ( String[] args ) {
        int[][] a = new int[][] {
                { 1 , 2 , 3 , 4 } ,
                { 5 , 6 , 7 , 8 } ,
                { 9 , 10 , 11 , 12 } ,
                { 13 , 14 , 15 , 16 } ,
        };

        //System.out.println( Arrays.deepToString( roateMatrix( a ) ) );
        //System.out.println( Arrays.deepToString( delFirstLine( a ) ) );
        printMatrix( a );
    }

    public static void printMatrix ( int[][] matrix ) {
        if ( matrix == null )
            return;
        for ( int i = 0 ; i < matrix[ 0 ].length ; i++ ) {
            System.out.println( matrix[ 0 ][ i ] );
        }
        int[][] t1 = delFirstLine( matrix );
        int[][] t2 = roateMatrix( t1 );
        printMatrix( t2 );
    }

    /*
    拿三行四列举例  after是旋转后数组 before是旋转前数组
    after[0][0] = before[0][3]
    after[0][1] = before[1][3]
    after[0][2] = before[2][3]

    after[1][0] = before[0][2]
    after[1][1] = before[1][2]
    after[2][2] = before[2][2]
    发现a的第二个维度等于b的第一个维度
    a的第二个维度+b的第二个维度 = before.col-1
     */
    public static int[][] roateMatrix ( int matrix[][] ) {
        if ( matrix.length == 0 )//这里不能写== null啊,得这么写
            return null;
        int row = matrix.length;
        int col = matrix[ 0 ].length;

        int[][] result = new int[ col ][ row ];
        for ( int i = 0 ; i < col ; i++ ) { //原来的列数是现在的行数
            for ( int j = 0 ; j < row ; j++ ) {//原来的列数是现在的行数
                result[ i ][ j ] = matrix[ j ][ col - 1 - i ];
            }
        }
        return result;
    }

    public static int[][] delFirstLine ( int matrix[][] ) {
        int row = matrix.length;
        int col = matrix[ 0 ].length;

        int[][] result = new int[ row - 1 ][ col ];
        for ( int i = 0 ; i < row - 1 ; i++ ) {
            for ( int j = 0 ; j < col ; j++ ) {
                result[ i ][ j ] = matrix[ i + 1 ][ j ];
            }
        }
        return result;
    }
}
