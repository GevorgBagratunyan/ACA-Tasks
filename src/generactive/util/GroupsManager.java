package generactive.util;

import generactive.model.Group;
import generactive.model.Item;

import java.util.HashMap;
import java.util.Map;

public class GroupsManager {
    private static int id = 0;
    private static Map<Integer, Group> groups = new HashMap<>();

    private GroupsManager() {

    }

    public static Group getByID(int id) {
        return groups.get(Integer.valueOf(id));
    }

    public static void addGroup(Group group) {
        groups.put(group.getId(), group);
    }

    public static int getId() {
        return ++id;
    }

    public static void print() {
        for (Map.Entry<Integer, Group> pair : groups.entrySet()) {
            pair.getValue().printContent();
        }
    }
}
