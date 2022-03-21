package future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1 finished!");
            return "future1 finished!";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future2 finished!");
            return "future2 finished!";
        });
        long t1=System.currentTimeMillis();
        CompletableFuture<Void> combindFuture = CompletableFuture.allOf(future1, future2);
        try {
            combindFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long t2=System.currentTimeMillis();
        System.out.println("future1: " + future1.isDone() + " future2: " + future2.isDone());

        System.out.println("t2-t1"+(t2-t1));
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1 finished!");
            return "future1 finished!";
        });
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future2 finished!");
            return "future2 finished!";
        });
        List<CompletableFuture> list=new ArrayList<>();
        CompletableFuture<Void> combindFuture2 = CompletableFuture.allOf(future3, future4);
        try {
            combindFuture2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long t3=System.currentTimeMillis();
        System.out.println("future3: " + future3.isDone() + " future4: " + future4.isDone());
        System.out.println("t3-t2"+(t3-t2));
    }
}
