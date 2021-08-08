package unisexbathroom;

public class BathroomUser implements Runnable {
    private String name;
    private Bathroom bathroom;
    Thread thread;

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
                    bathroom.semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bathroom.useBathroom();
                bathroom.semaphore.release();
            }

        }
    }

    public String getName() {
        return name;
    }
}
