package unisexbathroom;

import java.util.concurrent.Semaphore;

public class Bathroom {
    private Semaphore semaphore;
    private boolean isManInBathroom = false;
    private boolean isManTryingToEnter = false;
    private int count = 0;

    public Bathroom(int numOfUsers) {
        semaphore = new Semaphore(numOfUsers, false);
    }

    public void useBathroom() {
        if (!isAllowed()) {
            return;
        }
        System.out.println(Thread.currentThread().getName() + " entered. "
                + "\n******* count of users is: " + count + " ********");

        //Doing some stuff...
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " came out.");
    }

    //This method checks if all conditions are met, so that the user can use the Bathroom
    public synchronized boolean isAllowed() {

        //when available permits equals 3 it means that the bathroom is empty and allowed to everyone
        if (semaphore.availablePermits() == 3) {
            return true;
        }

        isManTryingToEnter = Thread.currentThread().getName().toLowerCase().startsWith("man");

        return (isManTryingToEnter && isManInBathroom) || (!isManTryingToEnter && !isManInBathroom);
    }

    public synchronized Semaphore getSemaphore() {
        return semaphore;
    }

    public synchronized void setIsManInBathroom(boolean isMan) {
        isManInBathroom = isMan;
    }

    public synchronized void incrCount() {
        count++;
    }

    public synchronized void decrCount() {
        count--;
    }
}
