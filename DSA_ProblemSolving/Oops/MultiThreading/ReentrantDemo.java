package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo {
    private final ReentrantLock lock = new ReentrantLock();

    public void methodA() {
        lock.lock();
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is in methodA");
            methodB(); // Calling another method that also requires the lock
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();// Same thread can acquire the lock again without deadlock
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is in methodB");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantDemo demo = new ReentrantDemo();
        Thread t1 = new Thread(demo::methodA, "T1");
        Thread t2 = new Thread(demo::methodA, "T2");

        t1.start();
        t2.start();
    }
}

/**
 * Reentrant is a java lock that provides exclusive access to a critical section of code, allowing only
 * one thread can hold the lock at a time.
 * In this example, we have a ReentrantLock that allows the same thread to acquire the lock multiple times without causing a deadlock.
 * The methodA() acquires the lock and then calls methodB(), which also tries to acquire the same lock.
 * Since the lock is reentrant, the thread can enter methodB() without any issues.
 * This demonstrates how reentrant locks work in Java, allowing for more flexible locking mechanisms in multi-threaded applications.
 */
