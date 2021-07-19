package generactive;

import generactive.model.Group;
import generactive.model.Item;
import generactive.model.itemtypes.GenerativeItem;
import generactive.util.Basket;
import generactive.util.Configuration;
import generactive.util.Storage;
import generactive.util.ItemCreator;
import generactive.util.enums.Complexity;
import generactive.util.enums.Resolution;


public class Main {
    public static void main(String[] args) {

        Group g1 = new Group.GroupBuilder()
                .setId()
                .setGroupName("Nature")
                .build();

        Group g2 = new Group.GroupBuilder()
                .setId()
                .setGroupName("Forest")
                .setParentGroup(g1)
                .build();

        Configuration cfg = new Configuration();
        cfg.setResolution(Resolution.UHD);

        GenerativeItem gi1 = new GenerativeItem.GenerativeItemBuilder()
                .setName("Visual1 in Forest")
                .setGroup(g2)
                .setPrice(25.0)
                .setComplexity(Complexity.TWO)
                .setConfiguration(cfg)
                .build();

        Basket.calculatePrice(gi1);

        //This is for console input flow
        //You can uncomment this part of code below to use console input
//        ItemCreator.create();
//        Storage.printAllGroups();
    }
}
