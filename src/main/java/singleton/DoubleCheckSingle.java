package singleton;

/**
 * 问题1，如果没有代码C
 * 假设线程t1,t2都执行到A处，因为还没有创建对象，所以他们都将执行代码B
 * 但是由于代码B是有锁的，只能一个线程执行完再执行另外一个线程
 * 当t1执行到E之前还未返回时，t2可能执行到D又new了一个对象，出现了2个实例。
 * 如果有C代码,只要synchronized代码块执行完，t==null则为false，D不会执行，不会出现2个及以上的实例。
 *
 * 问题2，如果没有代码A
 * 如果没有代码A也能保证单例，但是代码B和代码C一定会执行，这是没有必要的。所以代码A是提高性能的
 *
 * 问题3，single采用 volatile 关键字修饰是否必要
 * single =new DoubleCheckSingle();
 * 这段代码其实是分为三步执行：
 * 1. 为 single 分配内存空间
 * 2. 初始化 single
 * 3. 将 single 指向分配的内存地址
 * 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。指令重排在单线程环境下不会出先问题，但是在
 * 多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用
 * getInstance() 后发现 single 不为空，因此返回 single，但此时 single 还未被初始化。
 * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
 *
 */
public class DoubleCheckSingle {
    private static volatile DoubleCheckSingle single;

    private DoubleCheckSingle() {
    }
    public static DoubleCheckSingle getInstance(){
        if(single ==null){//A
            synchronized (DoubleCheckSingle.class){//B
                if(single ==null){//C
                    single =new DoubleCheckSingle();//D
                }
            }
        }
        return single;//E
    }
}
