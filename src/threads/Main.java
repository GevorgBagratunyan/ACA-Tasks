package threads;

public class Main {

    public static void main(String[] args) {

        Resource resource = new Resource();

        Producer p1 = new Producer( new String[] {"BIG ", "BROTHER ", "IS ", "WATCHING ", "YOU ", "!!!"}, resource);
        Producer p2 = new Producer( new String[] { "War is peace. ", "Freedom is slavery. ", "Ignorance is strength."}, resource);

        Consumer c1 = new Consumer(resource);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        Thread t3 = new Thread(c1);

        t1.start();
        t2.start();
        t3.start();

        System.out.println("\n====== After 5 seconds Producer p2 will stop his work ======\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //interrupting thread t2.
        p2.stop();

        System.out.println("\n===== Producer p2 stopped his work =====\n");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            System.out.println("\n******* Program will stop after 5 seconds *******\n");
            Thread.sleep(5000);

            p1.stop();
            c1.stop();

            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
