package MultiThreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadCpuIntensiveTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        int coreCount=Runtime.getRuntime().availableProcessors();
        System.out.println("Available Cores: " + coreCount);
        ExecutorService service= Executors.newFixedThreadPool(coreCount);
        for (int i=0;i<10;i++){
            service.execute(new FixedThreadCpuIntensiveTask());
        }
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }
}
