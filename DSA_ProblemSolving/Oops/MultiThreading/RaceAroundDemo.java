package MultiThreading;

public class RaceAroundDemo {
    static int count = 0;
    public static void increment() {
        count++;
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

        System.out.println("Final count: " + count);
    }

}

/**
 * Race condition occurs when two or more threads access shared data and try to change it at the same time.
 * In this example, we have two threads (t1 and t2) that both increment a shared variable count 10,000 times.
 * However, because the increment operation is not atomic, we may encounter a race condition where both threads read the same value of count before either has had a chance to write back the incremented value.
 * This can lead to lost updates and an incorrect final count.
 * To fix this issue, we can use synchronization or atomic variables to ensure that only one thread can modify the count variable at a time.
 */
