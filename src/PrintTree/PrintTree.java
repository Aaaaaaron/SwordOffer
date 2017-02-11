package PrintTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Melody on 2016/9/26.
 */
public class PrintTree {
    public static void main ( String[] args ) {
        TreeNode root = new TreeNode( 1 );
        TreeNode l1 = new TreeNode( 2 );
        TreeNode r1 = new TreeNode( 3 );
        TreeNode l2 = new TreeNode( 4 );
        TreeNode r2 = new TreeNode( 5 );
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        r1.right = r2;

        PrintTree test = new PrintTree();
        test.printTree( root );
    }

    public ArrayList< Integer > printFromTopToBottom ( TreeNode root ) {
        ArrayList< Integer > result = new ArrayList<>();
        Queue< TreeNode > supportQueue = new LinkedList<>();
        if ( root == null ) {
            return result;
        }
        supportQueue.add( root );
        while ( !supportQueue.isEmpty() ) {
            TreeNode temp = supportQueue.poll();
            if ( temp.left != null )
                supportQueue.add( temp.left );
            if ( temp.right != null )
                supportQueue.add( temp.right );
            result.add( temp.val );
        }
        return result;
    }

    //方法二
    public int[][] printTree ( TreeNode root ) {
        if ( root == null )
            return null;

        List< List< Integer > > result = new ArrayList<>();
        List< Integer > rowResult = new ArrayList<>();
        Queue< TreeNode > supportQueue = new LinkedList<>();
        TreeNode last = root;
        TreeNode nLast = null;
        TreeNode temp = null;
        supportQueue.add( root );
        while ( !supportQueue.isEmpty() ) {
            temp = supportQueue.poll();
            rowResult.add( temp.val );
            if ( temp.left != null ) {
                supportQueue.add( temp.left );
                nLast = temp.left;
            }
            if ( temp.right != null ) {
                supportQueue.add( temp.right );
                nLast = temp.right;
            }
            if ( temp == last ) {
                result.add( rowResult );
                rowResult.clear();
                last = nLast;
            }
        }
        for ( List< Integer > integerList : result ) {
            for ( Integer integer : integerList ) {
                System.out.print( integer + " " );
            }
            System.out.println();
        }

        int[][] a = new int[ result.size() ][];
        for ( int i = 0 ; i < result.size() ; i++ ) {
            a[ i ] = new int[ result.get( i ).size() ];
            for ( int j = 0 ; j < result.get( i ).size() ; j++ ) {
                a[ i ][ j ] = result.get( i ).get( j );
            }
        }
        return a;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode ( int val ) {
            this.val = val;

        }

    }
}
