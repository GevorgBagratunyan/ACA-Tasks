package generactive.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Item> items;

    public Basket() {
        items = new ArrayList<>();
    }

    public double totalPrice() {
        double total = 0.0;
        for (Item item : items) {
            if (item instanceof StockItem) {
                total += ((StockItem) item).calculatePrice();
            } else {
                total += ((GenerativeItem) item).calculatePrice();
            }
        }
        System.out.println(total);
        return total;
    }

    public void calculatePrice(Item item) {
        if (item instanceof StockItem) {
            System.out.println(((StockItem) item).calculatePrice());
        } else {
            System.out.println(((GenerativeItem) item).calculatePrice());
        }
    }

    public void addToBasket(Item item) {
        items.add(item);
    }

}
