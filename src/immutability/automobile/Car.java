package immutability.automobile;

public final class Car {
    private final int productionYear;
    private final String mark;
    private final String model;
    private final Engine engine;

    public Car(int productionYear, String mark, String model, Engine engine) {
        if (engine == null) {
            throw new IllegalArgumentException("Engine must not be null");
        }
        this.productionYear = productionYear;
        this.mark = mark;
        this.model = model;
        Engine temp = new Engine(engine.getHorsePower(), engine.getWeight(), engine.getMileage());
        this.engine = temp;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return new Engine(this.engine.getHorsePower(), this.engine.getWeight(), this.engine.getMileage());
    }
}
