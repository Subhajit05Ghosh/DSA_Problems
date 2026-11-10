package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {
    private static final ReentrantLock lock = new ReentrantLock();

public static void accessResource() {
    if (lock.tryLock()) {
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock and is accessing the resource.");
            // Simulate some work with the resource
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock.");
        }
    } else {
        System.out.println(Thread.currentThread().getName() + " could not acquire the lock and will not access the resource.");
    }
}

    public static void main(String[] args) {
        Thread t1 = new Thread(TryLockDemo::accessResource, "T1");
        Thread t2 = new Thread(TryLockDemo::accessResource, "T2");

        t1.start();
        t2.start();
    }
}

/**
 * In this example, we have a ReentrantLock that allows threads to attempt to acquire the lock without blocking.
 * The accessResource() method uses tryLock() to attempt to acquire the lock. If the lock is available, the thread acquires it and accesses the resource.
 * If the lock is not available, the thread does not block and instead prints a message indicating that it could not acquire the lock.
 * This demonstrates how tryLock() can be used to avoid blocking in multi-threaded applications, allowing threads to make progress even when a lock is held by another thread.
 */