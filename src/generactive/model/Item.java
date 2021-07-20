package generactive.model;

public abstract class Item {
    private final int id;
    private final String name;
    private final double price;
    private final Group group;
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
        System.out.println("Item group : " + this.group.getName());
        System.out.println("Item name : " + this.name);
        System.out.println("Item price : " + this.price);
        System.out.println("Item ID : " + this.id);
        System.out.println("____________________");
    }

    public abstract double calculatePrice();
}
