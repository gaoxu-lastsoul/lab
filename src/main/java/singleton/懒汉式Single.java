package singleton;

public class 懒汉式Single {
    private static 懒汉式Single single;

    private 懒汉式Single() {
    }

    public static 懒汉式Single getInstance() {
        if (single == null) {
            single = new 懒汉式Single();
        }
        return single;
    }
}
