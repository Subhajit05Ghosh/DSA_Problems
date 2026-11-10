package MultiThreading;

import java.util.concurrent.Semaphore;

public class ParkingLot {

    static Semaphore parkingSpaces = new Semaphore(2);

    static void park(){

            try {
                parkingSpaces.acquire();
                System.out.println(Thread.currentThread().getName() + " has parked.");
                Thread.sleep(2000); // Simulate parking duration
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                parkingSpaces.release();
                System.out.println(Thread.currentThread().getName() + " left.");
            }
    }

    public static void main(String[] args) {
        new Thread(ParkingLot::park, "Car 1").start();
        new Thread(ParkingLot::park, "Car 2").start();
        new Thread(ParkingLot::park, "Car 3").start();
    }
}

/**
 * Semaphore is a synchronization aid that restricts the number of threads that can access a resource concurrently.
 * In this example, we have a parking lot with a limited number of parking spaces (2 in this case).
 * The Semaphore is initialized with 2 permits, representing the available parking spaces.
 * Each car (thread) tries to acquire a permit before parking. If all spaces are occupied,
 * the car will wait until a space becomes available. After parking for 2 seconds, the car leaves,
 * releasing the permit for other cars to use.
 */