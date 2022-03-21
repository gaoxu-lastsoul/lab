public class Main {
    public static void main(String[] args) {
        Object a=new Object();
        Object b=new Object();
        System.out.println("=========");
        Runnable r=()->{
            while (true){
                synchronized (a){
                    synchronized (b){
                        System.out.println(1);
                    }
                }            }

        };
        Thread t=new Thread(r);
        t.start();

        Runnable r2=()->{
            while (true){
                synchronized (b){
                    synchronized (a){
                        System.out.println(2);
                    }
                }            }
        };
        Thread t2=new Thread(r2);
        t2.start();
    }
}
