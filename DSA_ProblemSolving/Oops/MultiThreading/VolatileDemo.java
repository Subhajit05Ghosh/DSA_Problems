package MultiThreading;

public class VolatileDemo {
    private static volatile boolean flag = false;

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
