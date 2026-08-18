package MultiThreading;

public class Threading {

    public static void main(String[] args) throws InterruptedException {

        // This object will be used as the common lock
        Object lock = new Object();

        // Thread 1
        Thread t1 = new Thread(() -> {

            synchronized (lock) {

                System.out.println("Thread-1 acquired the lock");

                try {
                    // Thread-1 sleeps for 5 seconds
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Thread-1 is releasing the lock");
            }

        }, "Thread-1");


        // Thread 2
        Thread t2 = new Thread(() -> {

            synchronized (lock) {

                // This can execute only after Thread-1 releases the lock
                System.out.println("Thread-2 entered");
            }

        }, "Thread-2");


        // Start Thread-1
        t1.start();

        // Give Thread-1 some time to acquire the lock
        Thread.sleep(200);

        // Start Thread-2
        t2.start();

        // Give Thread-2 some time to try acquiring the lock
        Thread.sleep(200);

        // Check Thread-2's state
        System.out.println(
                "Thread-2 state: " + t2.getState()
        );

        // Wait for both threads to finish
        t1.join();
        t2.join();

        System.out.println("Main thread finished");
    }
}









/*
                Main
                  │
                  │ t1.start()
                  ▼
             Thread-1
                  │
                  │ acquires lock
                  ▼
             synchronized
                  │
                  │ sleep(5 sec)
                  ▼
           TIMED_WAITING
           (still owns lock)
                  │
                  │
                  │ t2.start()
                  ▼
             Thread-2
                  │
                  │ tries synchronized(lock)
                  ▼
               BLOCKED
            (waiting for lock)
                  │
                  │
        Thread-1 wakes up
                  │
                  ▼
          releases lock
                  │
                  ▼
             Thread-2
                  │
                  │ acquires lock
                  ▼
          "Thread-2 entered"
                  │
                  ▼
               finishes
 */