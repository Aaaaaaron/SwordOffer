package DoesTreeAHaveTreeB;

/**
 * 判断二叉树B是不是二叉树A的子树
 */
public class DoesTreeAHaveTreeB {

    public static void main ( String args[] ) {
        TreeNode root1 = new TreeNode( 8 );
        TreeNode node1 = new TreeNode( 8 );
        TreeNode node2 = new TreeNode( 7 );
        TreeNode node3 = new TreeNode( 9 );
        TreeNode node4 = new TreeNode( 2 );
        TreeNode node5 = new TreeNode( 4 );
        TreeNode node6 = new TreeNode( 7 );
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        TreeNode root2 = new TreeNode( 8 );
        TreeNode a = new TreeNode( 9 );
        TreeNode b = new TreeNode( 2 );
        root2.left = a;
        root2.right = b;

        System.out.println( hasSubTree( root1, root2 ) );

    }

    public static boolean hasSubTree ( TreeNode treeA, TreeNode treeB ) {
        boolean result = false;
        if ( treeA != null && treeB != null ) {
            if ( treeA.val == treeB.val )
                result = doseTreeAHaveTreeB( treeA, treeB );
            if ( !result )
                result = hasSubTree( treeA.left, treeB );
            if ( !result )
                result = hasSubTree( treeA.right, treeB );
        }
        return result;
    }

    public static boolean doseTreeAHaveTreeB ( TreeNode treeA, TreeNode treeB ) {
        if ( treeB == null )
            return true;
        if ( treeA == null )
            return false;
        if ( treeA.val != treeB.val )
            return false;
        return doseTreeAHaveTreeB( treeA.left, treeB.left )
                && doseTreeAHaveTreeB( treeA.right, treeB.right );
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode () {
        }

        public TreeNode ( int val ) {
            this.val = val;
        }

    }
}
