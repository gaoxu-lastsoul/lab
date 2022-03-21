package thread;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ThreadTest {
    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> {
                    System.out.println(1);
                });
          CompletableFuture.runAsync(() -> {
            ThreadTest threadTest =new ThreadTest();
            threadTest.exe((Integer tt)->{
                for (int i=0;i<tt;i++){
                    System.out.println(i);
                }

            },10);

            System.out.println("future1 finished!");
        });
       CompletableFuture.runAsync(() -> {
            ThreadTest threadTest =new ThreadTest();
            threadTest.exe((Integer tt)->{
                for (int i=0;i<tt;i++){
                    System.out.println("future2"+i);
                }

            },10);
            System.out.println("future2 finished!");
        });

    }

    public  void exe(Consumer<Integer> c,Integer o){
        c.accept(o);
    }
}
