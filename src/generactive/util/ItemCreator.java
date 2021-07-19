package generactive.util;

import generactive.model.Configuration;
import generactive.model.Group;
import generactive.model.Item;
import generactive.model.GenerativeItem;
import generactive.model.StockItem;
import generactive.model.enums.Complexity;
import generactive.model.enums.Resolution;

public class ItemCreator {

    public static void create() {
        while (true) {
            ConsoleManager.readGroup();
            String groupName = ConsoleManager.getGroupName();
            Group parentGroup = ConsoleManager.getParentGroup();

            Group group = new Group.GroupBuilder()
                    .groupName(groupName)
                    .parentGroup(parentGroup)
                    .id()
                    .build();

            if (parentGroup != null) {
                parentGroup.getSubGroups().add(group);
            }
            Storage.addGroup(group);

            if (ConsoleManager.getUserCommand().equals("CONTINUE")) {
                ConsoleManager.readItem();
                String itemName = ConsoleManager.getItemName();
                double itemPrice = ConsoleManager.getPrice();
                Resolution resolution = ConsoleManager.getResolution();
                Complexity complexity = ConsoleManager.getComplexity();
                Configuration cfg = new Configuration();
                cfg.setResolution(resolution);
                Item item;

                if (complexity == null) {
                    item = new StockItem.StockItemBuilder()
                            .id()
                            .name(itemName)
                            .price(itemPrice)
                            .group(group)
                            .configuration(cfg)
                            .build();
                } else {
                    item = new GenerativeItem.GenerativeItemBuilder()
                            .id()
                            .name(itemName)
                            .price(itemPrice)
                            .group(group)
                            .configuration(cfg)
                            .complexity(complexity)
                            .build();
                }

                group.getItems().add(item);

                if (ConsoleManager.getUserCommand().equals("EXIT")) {
                    break;
                }
            }
        }
    }
}
