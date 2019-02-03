/**
 *
 */
public class TreeMirror {
    public static void main ( String[] args ) {
        TreeNode root1 = new TreeNode( 8 );

        TreeNode node1 = new TreeNode( 6 );
        TreeNode node2 = new TreeNode( 10 );

        TreeNode node3 = new TreeNode( 5 );
        TreeNode node4 = new TreeNode( 7 );

        TreeNode node5 = new TreeNode( 9 );
        TreeNode node6 = new TreeNode( 11 );
        root1.left = node1;
        root1.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        mirror( root1 );
        print( root1 );

    }

    public static void print ( TreeNode root ) {
        if ( root != null ) {
            System.out.println( root.val );
            print( root.left );
            print( root.right );
        }
    }

    public static void mirror ( TreeNode root ) {
        if ( root == null ) {
            return;
        }
        exchangeChildNode( root );
        mirror( root.left );
        mirror( root.right );
    }

    public static void exchangeChildNode ( TreeNode root ) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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
