package singleton;

public class StaticInnerClassSingle {

    private StaticInnerClassSingle() {
    }

    public static StaticInnerClassSingle getInstance() {
        return HolderSingle.t2;
    }

    private static class HolderSingle {
        private static StaticInnerClassSingle t2 = new StaticInnerClassSingle();
    }
}
