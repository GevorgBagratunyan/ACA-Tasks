package generactive.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int id;
    private String name;
    private Group parentGroup;
    private List<Group> subGroups;
    private List<Item> items;

    public Group() {
        items = new ArrayList<>();
        subGroups = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(Group parentGroup) {
        this.parentGroup = parentGroup;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void addSubGroup(Group group){
        subGroups.add(group);
    }

    public List<Group> getSubGroups() {
        return subGroups;
    }
}
