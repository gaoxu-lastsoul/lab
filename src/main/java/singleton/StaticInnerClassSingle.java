package singleton;

public class StaticInnerClassSingle {

    private StaticInnerClassSingle(){}
    public static StaticInnerClassSingle getInstance(){
        return HolderTest2.t2;
    }

    private static class HolderTest2{
        private  static StaticInnerClassSingle t2 = new StaticInnerClassSingle();
    }
}
