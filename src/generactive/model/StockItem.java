package generactive.model;

import generactive.util.Storage;

public class StockItem extends Item {

    public StockItem(StockItemBuilder builder) {
        super(builder.id, builder.name, builder.price, builder.group, builder.configuration);
    }

    public double calculatePrice() {
        double price = this.getPrice();
        double resolutionCoefficient = this.getConfiguration().getResolution().getResolutionCoefficient();
        return price * resolutionCoefficient;
    }

    public static class StockItemBuilder {
        private int id;
        private String name;
        private double price;
        private Group group;
        private Configuration configuration;

        public StockItemBuilder setID() {
            this.id = Storage.getNextItemID();
            return this;
        }

        public StockItemBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StockItemBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public StockItemBuilder setGroup(Group group) {
            this.group = group;
            return this;
        }

        public StockItemBuilder setConfiguration(Configuration configuration) {
            this.configuration = configuration;
            return this;
        }

        public StockItem build() {
            return new StockItem(this);
        }
    }
}
