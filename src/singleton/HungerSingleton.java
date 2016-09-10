package singleton;

/**
 * Created by taojiatao.aron on 2016/9/8.
 */
public class HungerSingleton
{
    private static HungerSingleton instance = new HungerSingleton();

    private HungerSingleton () {}

    public HungerSingleton getInstance ()
    {
        return instance;
    }
}
