package generactive;

import generactive.model.Group;
import generactive.model.GenerativeItem;
import generactive.model.Basket;
import generactive.model.Configuration;
import generactive.util.Storage;
import generactive.model.enums.Complexity;
import generactive.model.enums.Resolution;


public class Main {
    public static void main(String[] args) {

        Group g1 = new Group.GroupBuilder()
                .setID()
                .setGroupName("Nature")
                .build();

        Group g2 = new Group.GroupBuilder()
                .setID()
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

        g1.getSubGroups().add(g2);
        Storage.addGroup(g1);
        Storage.addGroup(g2);
        g2.getItems().add(gi1);

        System.out.print("Final price of gi1 Item is : ");
        Basket.calculatePrice(gi1);

        //This is for console input flow
        //You can uncomment this part of code below to use console input
//        ItemCreator.create();

        Storage.printAllGroups();
    }
}
