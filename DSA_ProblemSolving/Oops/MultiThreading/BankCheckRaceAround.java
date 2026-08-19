package MultiThreading;

/*
A race condition happens when two or more threads access and modify the same shared variable at the same time, and the result
 depends on which thread executes first.
 */
public class BankCheckRaceAround implements Runnable {
    int balance = 100;

/*    @Override
    public void run() {
        if (balance >= 100) {
            System.out.println("Withdrawing money:" + Thread.currentThread().getName());
            balance -= 50;
        } else {
            System.out.println("Withdrawal not done for:" + Thread.currentThread().getName());
            return;
        }
        System.out.println(Thread.currentThread().getName()+"::m.Withdrawal done, Balance:" + balance);
    }*/

    @Override
    public void run() {
        synchronized (this) {
            if (balance >= 100) {
                System.out.println("Withdrawing money:" + Thread.currentThread().getName());
                balance -= 50;
            } else {
                System.out.println("Withdrawal not done for:" + Thread.currentThread().getName());
                return;
            }
            System.out.println(Thread.currentThread().getName() + "::Withdrawal done, Balance:" + balance);
        }
    }

    public static void main(String[] args) {
        BankCheckRaceAround bank = new BankCheckRaceAround();
        Thread ramesh = new Thread(bank, "Ramesh");
        Thread suresh = new Thread(bank, "Suresh");
        ramesh.start();
        suresh.start();
    }

}

