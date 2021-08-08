package unisexbathroom;

public class Main {

    public static void main(String[] args) {
        Bathroom bathroom = new Bathroom(3);

        BathroomUser man1 = new Man("Man 1", bathroom);
        BathroomUser man2 = new Man("Man 2", bathroom);
        BathroomUser man3 = new Man("Man 3", bathroom);

        BathroomUser woman1 = new Woman("Woman 1", bathroom);
        BathroomUser woman2 = new Woman("Woman 2", bathroom);
        BathroomUser woman3 = new Woman("Woman 3", bathroom);

        try {
            man1.thread.join();
            man2.thread.join();
            man3.thread.join();
            woman1.thread.join();
            woman2.thread.join();
            woman3.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
