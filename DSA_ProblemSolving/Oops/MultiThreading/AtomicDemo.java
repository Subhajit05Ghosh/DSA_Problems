package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    static AtomicInteger count = new AtomicInteger(0);
    public static void increment() {
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + count.get());
    }

}

/**
 * An atomic operation is an operation that happens as one indivisible unit. Atomic is used for compound operations.
 * In this example, we use an AtomicInteger to ensure that the increment operation is atomic and thread-safe.
 * The incrementAndGet() method atomically increments the current value by one and returns the updated value.
 * This prevents race conditions and ensures that the final count is correct, even when multiple threads are
 * incrementing the count concurrently.
 */