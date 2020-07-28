package Module01;

import com.sun.source.tree.BreakTree;

/**
 * Package: Module01
 *
 * @author OriKey
 * @date 2020/7/28
 * --- 平凡才是唯一的答案 ---
 */
public class Singleton_hungry {
    // TODO: 2020/7/28  在类初始化时，已经自行实例化
    private static final Singleton_hungry instance = new Singleton_hungry();
    private Singleton_hungry(){}
    public static Singleton_hungry getInstanceA(){
        return instance;
    }

    static enum Single{
        SINGLE;
        private Singleton_hungry singleton_hungry;
        private Single(){
            singleton_hungry = new Singleton_hungry();
        }
        public Singleton_hungry getInstance(){
            return singleton_hungry;
        }
    }
    public static Singleton_hungry getInstanceB(){
        return Single.SINGLE.getInstance();
    }

    public static void main(String[] args) {
        Singleton_hungry singletonHungry = getInstanceB();
        Singleton_hungry singletonHungry1 = getInstanceB();
        System.out.println(singletonHungry==singletonHungry1);
    }

    
}
