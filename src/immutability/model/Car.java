package immutability.model;

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
        this.engine = engine.copy();
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
        return this.engine.copy();
    }
}
