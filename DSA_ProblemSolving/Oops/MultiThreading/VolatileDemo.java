package MultiThreading;

public class VolatileDemo {
   // private static volatile boolean flag = false;
    private static boolean flag = false;


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 started");
            while (!flag) {
                // Busy-wait until flag becomes true
            }
            System.out.println("t1 detected flag change");

        });
        t1.start();
        Thread.sleep(2000);
        flag = true;
        System.out.println("Main thread set flag to true");
    }
}

/**
 * Volatile is a keyword in Java that is used to indicate that a variable's value may be changed by different threads.
 * When a variable is declared as volatile, it tells the Java Virtual Machine (JVM) that the value of this variable
 * can be modified by multiple threads and should not be cached or optimized in a way that could lead to inconsistent
 * views of the variable's value across threads.
 * In this example, the `flag` variable is declared as `volatile`. This ensures that when the main thread updates
 * the value of `flag`, the change is immediately visible to thread `t1`. Without the `volatile` keyword, thread `t1`
 * might not see the updated value of `flag` due to caching or compiler optimizations, leading to an infinite loop.
 * By using `volatile`, we guarantee that `t1` will eventually detect the change and exit the loop.
 */

/**When a variable is accessed by multiple threads, the Java Memory Model allows threads to cache variables
 *in their local memory for performance reasons. This can lead to situations where one thread updates a variable,
 * but other threads do not see the updated value because they are reading from their cached copy. After using volatile
 * it ensures that the variable is always read from and written to main memory, preventing threads from caching its value.
 */
