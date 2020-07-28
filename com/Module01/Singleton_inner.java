package Module01;

/**
 * Package: Module01
 * Created by OriKey on 2020/7/28.
 * --- 平凡才是唯一的答案 ---
 */
public class Singleton_inner {
    // TODO: 2020/7/28 加载一个类的时候，其内部类不会被加载。
    //  一个类被加载，当且仅当某个静态成员被调用时发生，StaticSingleton.getInstance() 的时候，才会对单例进行初始化，
    //  而且通过反射，是不能从外部类获取内部类的属性的；
    //  由于静态内部类的特性，只有在其被第一次引用的时候才会被加载，所以可以保证其线程安全性。
    //  所谓的反射入侵，是指通过反射的方式调用私有的构造器从而创造处不同的对象。
    private Singleton_inner(){}
    public static Singleton_inner getInstance(){
        return StaticSingletonHolder.instance;
    }
    private static class StaticSingletonHolder{
        private static final Singleton_inner instance = new Singleton_inner();
    }

    public static void main(String[] args) {
        Singleton_inner inner= getInstance();
        Singleton_inner inner2 = getInstance();
        System.out.println(inner==inner2);
    }
}
