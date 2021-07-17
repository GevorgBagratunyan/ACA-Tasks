package generactive.util;

import generactive.model.Group;
import generactive.model.Item;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static int id = 0;
    private static Map<Integer, Group> groups = new HashMap<>();
    private static Map<String, Item> items = new HashMap<>();

    private Storage() {
    }

    public static Group getByID(int id) {
        return groups.get(Integer.valueOf(id));
    }

    public static void addGroup(Group group) {
        groups.put(group.getId(), group);
    }

    public static Item getByName(String itemName) {
        return items.get(itemName);
    }

    public static void addItem(Item item) {
        items.put(item.getName(),item);
    }

    public static int getId() {
        return ++id;
    }

    public static void printAllGroups() {
        for (Map.Entry<Integer, Group> pair : groups.entrySet()) {
            pair.getValue().printContent();
        }
    }

    public static void printAllItems() {
        for (Map.Entry<String, Item> pair : items.entrySet()) {
            pair.getValue().printContent();
        }
    }
}
