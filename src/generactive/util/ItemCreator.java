package generactive.util;

import generactive.model.Group;
import generactive.model.Item;

public class ItemCreator {

    public static void create() {
        while (true) {
            ConsoleManager.readGroup();
            String groupName = ConsoleManager.getGroupName();
            Group parentGroup = ConsoleManager.getParentGroup();
            int id = GroupsManager.getId();

            Group group = new Group.GroupBuilder()
                    .setGroupName(groupName)
                    .setParentGroup(parentGroup)
                    .setId(id)
                    .build();

            if (parentGroup != null) {
                parentGroup.getSubGroups().add(group);
            }
            GroupsManager.addGroup(group);

            if (ConsoleManager.getUserCommand().equals("CONTINUE")) {
                ConsoleManager.readItem();
                String itemName = ConsoleManager.getItemName();
                int itemPrice = ConsoleManager.getPrice();

                Item item = new Item.ItemBuilder()
                        .setName(itemName)
                        .setPrice(itemPrice)
                        .setGroup(group)
                        .build();

                group.getItems().add(item);

                if (ConsoleManager.getUserCommand().equals("EXIT")) {
                    break;
                }

            }
        }
    }
}
