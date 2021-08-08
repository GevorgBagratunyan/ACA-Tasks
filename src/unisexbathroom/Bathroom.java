package unisexbathroom;

import java.util.concurrent.Semaphore;

public class Bathroom {
    Semaphore semaphore;
    private boolean isManInBathroom = false;
    private boolean isManTryingToEnter = false;
    private boolean isBathroomEmpty = true;
    private int count = 0;

    public Bathroom(int numOfUsers) {
        semaphore = new Semaphore(numOfUsers, false);
    }

    public void useBathroom() {
        isManInBathroom = Thread.currentThread().getName().toLowerCase().startsWith("man");
        System.out.println(Thread.currentThread().getName() + " entered. "
                + "\n******* count of users is: " + ++count + " ********");

        //Doing some stuff...
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " came out.");
        count--;
    }

    //This method checks if all conditions are met, so that the user can use the Bathroom
    public synchronized boolean isAllowed() {

        isManTryingToEnter = Thread.currentThread().getName().toLowerCase().startsWith("man");

        if (count == 0) {
            isBathroomEmpty = true;
            isManInBathroom = Thread.currentThread().getName().toLowerCase().startsWith("man");
            return true;
        } else {
            isBathroomEmpty = false;
        }

        return (isManTryingToEnter && isManInBathroom) || (!isManInBathroom && !isManTryingToEnter);
    }
}
