package Module01;

/**
 * Package: Module01
 * Created by OriKey on 2020/7/28.
 * --- 平凡才是唯一的答案 ---
 */
/*
* 关于单例模式
* 单例模式的实现有两大类：懒汉模式和饿汉模式
* 懒汉模式代表在进行使用的时候才会创建相应的对象
* 饿汉模式代表在最开始容器生成的时候就会创建相应的对象
* 一下提供懒汉模式的创建：
*    对于懒汉模式来说，主要有一下四种实现
*       1、适用于单线程环境（不推荐）
        2、适用于多线程环境，但效率不高（不推荐）
        3、双重检验锁
        4、静态内部类方式（推荐）
* */
public class Singleton_lazy {
    private static Singleton_lazy instance = null;
    Singleton_lazy(){}
    // TODO: 2020/7/28 只适用于单线程环境
    /*
    * 此方法的主要缺点在于由于其不是原子操作，因此这就导致对应的实例在进行获取的时候
    * 可能会出现instance已经双双判断完毕，之后同步执行new操作
    * */
    public static Singleton_lazy getInstanceA(){
        if (null==instance){
            instance = new Singleton_lazy();
        }
        return instance;
    }
    // TODO: 2020/7/28 使用synchronized方法，适用于多线程环境，但是效率不高
    /*
    * 此方法应用了synchronized关键字表示方法，保证原子性，但是效率比较低下
    * */
    public static synchronized Singleton_lazy getInstanceB(){
        if (null == instance) {
            instance = new Singleton_lazy();
        }
        return instance;
    }
    // TODO: 2020/7/28  使用双重检查加锁的方式进行判断
    /*
    *  此方法减少了同步的代码块区域来提高效率
    * */
    public static Singleton_lazy getInstanceC(){
        if (null == instance) {
            synchronized (Singleton_lazy.class){
                //判断在对对象加锁期间，其余线程是否已经获取了instance对象
                if (null == instance) {
                    instance = new Singleton_lazy();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton_lazy singleton_lazy= getInstanceA();
        Singleton_lazy singleton_lazy1 = getInstanceC();
        Singleton_lazy singleton_lazy2 =getInstanceB();
        System.out.println(singleton_lazy==singleton_lazy1);
        System.out.println(singleton_lazy1==singleton_lazy2);
    }
}






















