package MultiThreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread Name-- run method: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(10);
        for (int i=0;i<10;i++){
            service.execute(new FixedThreadTask());
        }
        System.out.println("Thread Name-- main method: " + Thread.currentThread().getName());
    }
}

/**
 * In this example, we are using a fixed thread pool with a size of 10 threads.
 * This is suitable for tasks that are not CPU-intensive and can be executed concurrently without overwhelming the system.
 * The executor service will manage the threads and reuse them for executing multiple tasks, improving resource utilization and performance.
 */