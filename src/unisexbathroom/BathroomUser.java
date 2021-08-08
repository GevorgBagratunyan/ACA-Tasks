package unisexbathroom;

public class BathroomUser implements Runnable {
    private final String name;
    private final Bathroom bathroom;
    private final Thread thread;

    public BathroomUser(String name, Bathroom bathroom) {
        this.name = name;
        this.bathroom = bathroom;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {

            //Trying to get to the bathroom every 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(bathroom.isAllowed()){
                try {
                    bathroom.getSemaphore().acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bathroom.useBathroom();
                bathroom.getSemaphore().release();
            }

        }
    }

    public Thread getThread() {
        return thread;
    }
}
