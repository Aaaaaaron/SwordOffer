package singleton;

/**
 * 对于序列化还是会有些问题
 */
public class DCLSingleton
{
    //一定要保证内存可见性
    private static volatile DCLSingleton singleton;

    private DCLSingleton () {}

    public DCLSingleton getInstance ()
    {
        if ( singleton == null )
        {
            synchronized ( DCLSingleton.class )
            {
                if ( singleton == null )
                    singleton = new DCLSingleton();
            }
        }
        return singleton;
    }
}
