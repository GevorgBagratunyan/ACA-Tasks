package generactive.util;


import generactive.model.Group;
import generactive.model.Item;

public class ItemBuilder {
    public static void build() {
        while (true) {
            Group group = ConsoleManager.createGroup();
            GroupsManager.addGroup(group);
            if (ConsoleManager.getUserCommand().toUpperCase().equals("CONTINUE")) {
                Item item = ConsoleManager.createItem();
                group.addItem(item);
            }
            if (ConsoleManager.getUserCommand().toUpperCase().equals("EXIT")) {
                break;
            }
        }
    }
}
