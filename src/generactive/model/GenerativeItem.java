package generactive.model;

import generactive.model.enums.Complexity;
import generactive.util.Storage;;

public class GenerativeItem extends Item {

    private final Complexity complexity;

    public GenerativeItem(GenerativeItemBuilder builder) {
        super(builder.id, builder.name, builder.price, builder.group, builder.configuration);
        complexity = builder.complexity;
    }

    public double calculatePrice() {
        double price = this.getPrice();
        double resolutionCoefficient = this.getConfiguration().getResolution().getResolutionCoefficient();
        double comp = complexity.getValue();
        return price * resolutionCoefficient * comp;
    }

    public static class GenerativeItemBuilder {
        private int id;
        private String name;
        private double price;
        private Group group;
        private Configuration configuration;
        private Complexity complexity;

        public GenerativeItemBuilder setID() {
            this.id = Storage.getNextItemID();
            return this;
        }

        public GenerativeItemBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public GenerativeItemBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public GenerativeItemBuilder setGroup(Group group) {
            this.group = group;
            return this;
        }

        public GenerativeItemBuilder setConfiguration(Configuration configuration) {
            this.configuration = configuration;
            return this;
        }

        public GenerativeItemBuilder setComplexity(Complexity complexity) {
            this.complexity = complexity;
            return this;
        }

        public GenerativeItem build() {
            return new GenerativeItem(this);
        }
    }
}
