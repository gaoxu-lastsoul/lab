package thread;

import java.text.SimpleDateFormat;


/**
 * https://mp.weixin.qq.com/s/2139B5EfyoUkbkSdz8QgYA
 * 下面t1,t2是两个不同对象，相当于不同业务的两个ThreadLocal，但是他们里面的ThreadLocalMap是同一个
 * 因为ThreadLocalMap引用来自当前Thread类，并且t1,t2都是在同一个线程（主线程）
 * <p>
 * ThreadLocal.withInitial()的值为默认值，即不调用set方法时的值。下面例子中：
 * t1.get()是没有值的所以会返回默认的"aaa"，t2.get()由于设置过“BBB"所以返回BBB
 * 后面调用t2.remove后”BBB“删除，再调用t2.get()会返回默认值"bbb"
 */

public class ThreadLocalTest {

    public static void main(String[] args) {

        ThreadLocal ta = new ThreadLocal();
        ta.set("CCC");
        ThreadLocal tb = new ThreadLocal();
        tb.set("DDD");
        System.out.println(ta.get());//CCC
        System.out.println(tb.get());//DDD
        ta.remove();
        System.out.println(ta.get());//null
        System.out.println(tb.get());//DDD

        //ThreadLocal.withInitial()的值为默认值，即不调用set方法时的值。
        ThreadLocal t1 = ThreadLocal.withInitial(() -> "aaa");
        ThreadLocal t2 = ThreadLocal.withInitial(() -> "bbb");
        t2.set("BBB");
        //返回默认的"aaa"
        System.out.println(t1.get());
        //由于设置过“BBB"所以返回BBB
        System.out.println(t2.get());
        t2.remove();
        //t2.remove后”BBB“删除，再调用t2.get()会返回默认值"bbb"
        System.out.println(t2.get());
    }
}
