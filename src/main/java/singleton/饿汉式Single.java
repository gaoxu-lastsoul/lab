package singleton;

public class 饿汉式Single {
    private static 饿汉式Single single = new 饿汉式Single();

    private 饿汉式Single() {
    }

    public static 饿汉式Single getInstance() {

        return single;
    }
}
