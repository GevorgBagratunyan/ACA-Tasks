package generactive.model.itemtypes;

import generactive.model.Group;
import generactive.model.Item;
import generactive.util.Configuration;

public class StockItem extends Item {

    private final Configuration configuration;

    public StockItem(StockItemBuilder builder) {
        super(builder.name, builder.price, builder.group);
        configuration = builder.configuration;
    }

    public double calculatePrice() {
        double price = this.getPrice();
        double resolutionCoefficient = configuration.getResolution().getResolutionCoefficient();
        return price * resolutionCoefficient;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public  static class StockItemBuilder {
        private String name;
        private double price;
        private Group group;
        private Configuration configuration;

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

        public StockItem build(){
            return new StockItem(this);
        }
    }
}
