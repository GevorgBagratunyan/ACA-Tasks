package generactive.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final int id;
    private final String groupName;
    private final Group parentGroup;
    private final List<Group> subGroups;
    private final List<Item> items;

    public Group(GroupBuilder builder) {
        this.id = builder.id;
        this.groupName = builder.groupName;
        this.parentGroup = builder.parentGroup;
        this.subGroups = builder.subGroups;
        this.items = builder.items;
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public Group getParentGroup() {
        return parentGroup;
    }

    public List<Group> getSubGroups() {
        return subGroups;
    }

    public List<Item> getItems() {
        return items;
    }


    public void printContent() {
        System.out.println("Group ID : " + id + "\nName : " + groupName);
        System.out.print("Items in this Group -> ");

        if (!items.isEmpty()) {
            for (Item item : items) {
                System.out.print(item.getName() + " ");
            }
        } else System.out.println();

        if (!subGroups.isEmpty()) {
            System.out.println("Subgroups in this Group -> ");
            for (Group group : subGroups) {
                group.printContent();
            }
        } else System.out.println();
        System.out.println("\n____________________");
    }

    public static class GroupBuilder {

        private int id;
        private String groupName;
        private Group parentGroup;
        private final List<Group> subGroups;
        private final List<Item> items;

        public GroupBuilder() {
            this.subGroups = new ArrayList<>();
            this.items = new ArrayList<>();
        }

        public GroupBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public GroupBuilder setGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public GroupBuilder setParentGroup(Group parentGroup) {
            this.parentGroup = parentGroup;
            return this;
        }

        public Group build() {
            return new Group(this);
        }
    }

}
