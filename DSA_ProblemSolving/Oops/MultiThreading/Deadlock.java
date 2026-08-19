package MultiThreading;

public class Deadlock {


    /* A deadlock is a situation in which two or more threads are blocked forever, waiting for each other.
     It occurs when two or more threads have a circular dependency on a pair of synchronized objects.
     */
    public static void main(String[] args) {
   Object varsha_key=new Object();
   Object harsha_key=new Object();

   Thread varsha=new Thread(()-> {
       synchronized (varsha_key) {
           System.out.println("Varsha has acquired harsha_key");
           try {
               System.out.println("Varsha is sleeping for 3 second");
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           System.out.println("Varsha is waiting for harsha_key");
           synchronized (harsha_key) {
               System.out.println("Varsha has harsha_key");
           }
       }
   });

/*        Thread harsha=new Thread(()-> {
            synchronized (varsha_key) {
                System.out.println("Harsha has acquired varsha_key");
                try {
                    System.out.println("Harsha is sleeping for 3 second");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Harsha is waiting for harsha_key");
                synchronized (harsha_key) {
                    System.out.println("Harsha has harsha_key");
                }
            }
        });*/

        Thread harsha=new Thread(()-> {
            synchronized (harsha_key) {
                System.out.println("Harsha has acquired varsha_key");
                try {
                    System.out.println("Harsha is sleeping for 3 second");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Harsha is waiting for harsha_key");
                synchronized (varsha_key) {
                    System.out.println("Harsha has harsha_key");
                }
            }
        });
        varsha.start();
        harsha.start();

    }

}

