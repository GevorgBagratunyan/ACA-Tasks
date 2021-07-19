package generactive.model.itemtypes;

import generactive.model.Group;
import generactive.model.Item;
import generactive.util.Configuration;
import generactive.util.enums.Complexity;;

public class GenerativeItem extends Item {

    private  final Configuration configuration;
    private  final Complexity complexity;

    public GenerativeItem(GenerativeItemBuilder builder) {
        super(builder.name, builder.price, builder.group);
        configuration = builder.configuration;
        complexity = builder.complexity;
    }

    public double calculatePrice() {
        double price = this.getPrice();
        double resolutionCoefficient = configuration.getResolution().getResolutionCoefficient();
        double comp = complexity.getValue();
        return price * resolutionCoefficient * comp;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public  static class GenerativeItemBuilder {
        private String name;
        private double price;
        private Group group;
        private Configuration configuration;
        private Complexity complexity;

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

        public GenerativeItemBuilder setComplexity(Complexity complexity){
            this.complexity = complexity;
            return this;
        }

        public GenerativeItem build(){
            return new GenerativeItem(this);
        }
    }
}
