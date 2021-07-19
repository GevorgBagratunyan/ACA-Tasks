package generactive.model;

public class Item {
    private String name;
    private double price;
    private Group group;

    public Item(String name, double price, Group group) {
        this.name = name;
        this.price = price;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Group getGroup() {
        return group;
    }


    public void printContent() {
        System.out.println("Item group : " + this.group.getGroupName());
        System.out.println("Item name : " + this.name);
        System.out.println("Item price : " + this.price);
        System.out.println("____________________");
    }
}
