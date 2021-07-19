package generactive.model;

public class Item {
    private int id;
    private String name;
    private double price;
    private Group group;
    private final Configuration configuration;


    public Item(int id, String name, double price, Group group, Configuration configuration) {
        this.name = name;
        this.price = price;
        this.group = group;
        this.id = id;
        this.configuration = configuration;
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

    public int getId() {
        return id;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void printContent() {
        System.out.println("Item group : " + this.group.getGroupName());
        System.out.println("Item name : " + this.name);
        System.out.println("Item price : " + this.price);
        System.out.println("Item ID : " + this.id);
        System.out.println("____________________");
    }
}
