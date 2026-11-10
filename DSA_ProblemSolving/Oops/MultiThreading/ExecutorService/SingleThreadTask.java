package MultiThreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService service= Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++){
            service.execute(new SingleThreadTask());
        }
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }
}

/**
 * In this example, we are using a single-threaded executor service.
 * This is suitable for tasks that need to be executed sequentially, ensuring that only one task is running at a time.
 * The executor service will manage the single thread and execute the tasks in the order they are submitted, providing a simple way to handle sequential execution without manually managing threads.
 */