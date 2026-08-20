package MultiThreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            service.execute(new CachedThreadTask());
        }
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }
}
