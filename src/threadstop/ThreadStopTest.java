package threadstop;

public class ThreadStopTest {

    static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while(!stop){
                System.out.println("Thread t1 is running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            while(!stop){
                System.out.println("Thread t2 is running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread 2");

        t1.start();
        t2.start();

        System.out.println("Giving threads 3 sec to work");
        Thread.sleep(3000);

        //Stopping all threads
        stop();
        Thread.sleep(1000);
        System.out.println(t1.getName() + " is " + t1.getState() + "\n" + t2.getName() + " is " + t2.getState());

    }

    static void stop() {
        stop=true;
    }
}
