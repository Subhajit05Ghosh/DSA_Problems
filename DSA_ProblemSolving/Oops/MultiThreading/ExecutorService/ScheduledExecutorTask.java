package MultiThreading.ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ScheduledExecutorTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.schedule(new ScheduledExecutorTask(), 10,SECONDS );
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        service.scheduleAtFixedRate(new ScheduledExecutorTask(), 15, 10, SECONDS);
        service.scheduleWithFixedDelay(new ScheduledExecutorTask(), 15, 10, SECONDS);
    }
}
