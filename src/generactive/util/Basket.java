package generactive.util;

import generactive.model.Item;
import generactive.model.itemtypes.GenerativeItem;
import generactive.model.itemtypes.StockItem;

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
