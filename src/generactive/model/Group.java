package generactive.model;

import generactive.util.Storage;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final int id;
    private final String name;
    private final Group parent;
    private final List<Group> subGroups;
    private final List<Item> items;

    public Group(GroupBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.parent = builder.parent;
        this.subGroups = builder.subGroups;
        this.items = builder.items;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Group getParent() {
        return parent;
    }

    public List<Group> getSubGroups() {
        return subGroups;
    }

    public List<Item> getItems() {
        return items;
    }


    public void printContent() {
        System.out.println("Group ID : " + id + "\nName : " + name);
        System.out.print("Items in this Group -> ");

        if (!items.isEmpty()) {
            for (Item item : items) {
                System.out.print(item.getName() + " ");
            }
        } else System.out.println();

        System.out.println();
        System.out.println("Subgroups in this Group -> ");
        if (!subGroups.isEmpty()) {
            for (Group group : subGroups) {
                group.printContent();
            }
        } else System.out.println();
        System.out.println("____________________");
    }

    public static class GroupBuilder {

        private int id;
        private String name;
        private Group parent;
        private final List<Group> subGroups;
        private final List<Item> items;

        public GroupBuilder() {
            this.subGroups = new ArrayList<>();
            this.items = new ArrayList<>();
        }

        public GroupBuilder id() {
            this.id = Storage.getNextGroupID();
            return this;
        }

        public GroupBuilder groupName(String name) {
            this.name = name;
            return this;
        }

        public GroupBuilder parentGroup(Group parent) {
            this.parent = parent;
            return this;
        }

        public GroupBuilder addSubgroup(Group group){
            this.subGroups.add(group);
            return this;
        }

        public Group build() {
            return new Group(this);
        }
    }

}
