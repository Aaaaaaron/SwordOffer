package FindInPartiallySortedMatirx;

import org.junit.Assert;
import org.junit.Test;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的数序排列。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class FindInPartiallySortedMatirx {
    //递归版本
    public static boolean isFind ( int[][] array, int num ) {
        return find( array, 0, array[ 0 ].length - 1, num );
    }

    public static boolean find ( int[][] array, int row, int column, int num ) {
        if ( array == null || row > array[ 0 ].length - 1 || column < 0 ) {
            return false;
        }
        if ( array[ row ][ column ] > num ) {
            return find( array, row, column - 1, num );
        }
        else if ( array[ row ][ column ] < num ) {
            return find( array, row + 1, column, num );
        }
        else {
            return true;
        }
    }

    //非递归版本
    public boolean find ( int[][] array, int target ) {
        int len = array.length - 1;
        int i = 0;
        while ( ( len >= 0 ) && ( i < array[ 0 ].length ) ) {
            if ( array[ len ][ i ] > target )
                len--;
            else if ( array[ len ][ i ] < target )
                i++;
            else
                return true;
        }
        return false;
    }

    @Test
    public void testFind () {
        int[][] matrix = {
                { 1 , 2 , 8 , 9 } ,
                { 2 , 4 , 9 , 12 } ,
                { 4 , 7 , 10 , 13 } ,
                { 6 , 8 , 11 , 15 }
        };

        Assert.assertTrue( isFind( matrix, 7 ) );
        Assert.assertTrue( isFind( matrix, 6 ) );
        Assert.assertFalse( isFind( matrix, 3 ) );
        Assert.assertTrue( isFind( matrix, 4 ) );
        Assert.assertFalse( isFind( matrix, 0 ) );
        Assert.assertFalse( isFind( matrix, 1000 ) );
        //System.out.println( isFind( matrix, 1000 ) );
    }

}
