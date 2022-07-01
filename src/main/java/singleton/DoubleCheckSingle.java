package singleton;

public class DoubleCheckSingle {
    private static volatile DoubleCheckSingle t;
    private DoubleCheckSingle(){}
    public static DoubleCheckSingle getInstance(){
        if(t==null){
            synchronized (DoubleCheckSingle.class){
                if(t==null){
                    t=new DoubleCheckSingle();
                }
            }
        }
        return t;
    }
}
