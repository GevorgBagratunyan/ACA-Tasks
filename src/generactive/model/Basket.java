package generactive.model;

public class Basket {

    private Basket() {
    }

    public static void calculatePrice(Item item) {
        if (item instanceof StockItem) {
            System.out.println(((StockItem) item).calculatePrice());
        } else {
            System.out.println(((GenerativeItem) item).calculatePrice());
        }
    }
}
