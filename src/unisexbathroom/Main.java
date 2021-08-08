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
            man1.getThread().join();
            man2.getThread().join();
            man3.getThread().join();
            woman1.getThread().join();
            woman2.getThread().join();
            woman3.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
