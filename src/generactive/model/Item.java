package generactive.model;

public class Item {
    private final String name;
    private final int price;
    private final Group group;

    public Item(ItemBuilder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.group = builder.group;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Group getGroup() {
        return group;
    }

    public static class ItemBuilder {

        private String name;
        private int price;
        private Group group;

        public ItemBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public ItemBuilder setGroup(Group group) {
            this.group = group;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }
}
