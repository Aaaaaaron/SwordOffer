import java.util.Arrays;

/**
 * 1 247 3568
 * 472 1 5386
 * <p>
 * 2 47
 * 47 2
 * <p>
 * 4 7
 * 4 7
 * 根是4 7是4的右子树 回溯
 * 同理3568
 * 关键在于不断的构造左右子树
 */
public class ConstructBinaryTree {
    public static void main ( String[] args ) throws Exception {
        int[] preOrder = new int[] { 1 , 2 , 4 , 7 , 3 , 5 , 6 , 8 };
        int[] inOrder = new int[] { 4 , 7 , 2 , 1 , 5 , 3 , 8 , 6 };
        BinaryTreeNode root = construct( preOrder, inOrder );
        print( root );
    }

    public static BinaryTreeNode construct ( int[] preOrder, int[] inOrder ) throws Exception {
        boolean isHave = false;
        if ( preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0 ) {
            return null;
        }
        if ( preOrder.length != inOrder.length ) {
            throw new Exception( "长度不一样－非法输入" );
        }

        BinaryTreeNode root = new BinaryTreeNode( preOrder[ 0 ] );
        for ( int i = 0 ; i < inOrder.length ; i++ ) {
            if ( inOrder[ i ] == preOrder[ 0 ] ) {
                isHave = true;
                root.leftChild =
                        construct( Arrays.copyOfRange( preOrder, 1, i + 1 ),
                                Arrays.copyOfRange( inOrder, 0, i ) );
                root.rightChild =
                        construct( Arrays.copyOfRange( preOrder, i + 1, preOrder.length ),
                                Arrays.copyOfRange( inOrder, i + 1, inOrder.length ) );
            }
        }
        if ( !isHave ) {
            throw new Exception( "不包含根节点－非法输入" );
        }
        return root;
    }

    public static void print ( BinaryTreeNode root ) {
        if ( root != null ) {
            System.out.println( root.value );
            print( root.leftChild );
            print( root.rightChild );
        }
    }

    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;

        public BinaryTreeNode ( int value ) {
            this.value = value;
        }
    }
}
