package immutability.model;

public class Engine {
    private int horsePower;
    private int weight;
    private int mileage;

    public Engine(int horsePower, int weight, int mileage) {
        this.horsePower = horsePower;
        this.weight = weight;
        this.mileage = mileage;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Engine copy() {
        return new Engine(this.horsePower, this.weight, this.mileage);
    }
}
