package MultiThreading;

public class ThreadWait {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread worker = new Thread(() -> {

            synchronized (lock) {

                try {
                    System.out.println("Worker is waiting...");

                    lock.wait();

                    System.out.println("Worker woke up!");

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        });

        // Start worker thread
        worker.start();

        // Give worker some time to reach wait()
        Thread.sleep(200);

        // Check worker's state
        System.out.println("Worker state: " + worker.getState());

        // Wake up the worker
        synchronized (lock) {
            lock.notifyAll();
        }

        // Wait for worker to finish
        worker.join();

        System.out.println("Main thread finished");
    }
}



/*

Before wait():

Worker
  ↓
owns lock


After wait():

Worker
  ↓
WAITING
  ↓
releases lock

 */