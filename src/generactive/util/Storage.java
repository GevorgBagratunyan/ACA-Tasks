package generactive.util;

import generactive.model.Group;
import generactive.model.Item;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static int groupID = 0;
    private static int itemID = 0;
    private static final Map<Integer, Group> GROUPS = new HashMap<>();
    private static final Map<String, Item> ITEMS = new HashMap<>();

    private Storage() {
    }

    public static Group getByID(int id) {
        return GROUPS.get(id);
    }

    public static void addGroup(Group group) {
        GROUPS.put(group.getId(), group);
    }

    public static Item getByName(String itemName) {
        return ITEMS.get(itemName);
    }

    public static void addItem(Item item) {
        ITEMS.put(item.getName(), item);
    }

    public static int getNextGroupID() {
        return ++groupID;
    }

    public static int getNextItemID() {
        return ++itemID;
    }

    public static void printAllGroups() {
        for (Map.Entry<Integer, Group> pair : GROUPS.entrySet()) {
            pair.getValue().printContent();
        }
    }

    public static void printAllItems() {
        for (Map.Entry<String, Item> pair : ITEMS.entrySet()) {
            pair.getValue().printContent();
        }
    }
}
