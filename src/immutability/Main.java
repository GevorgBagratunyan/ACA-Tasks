package immutability;

import immutability.automobile.Car;
import immutability.automobile.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(485, 521, 85400);
        Car car = new Car(2021, "Dodge", "Challenger", engine);
        System.out.println("Horsepower BEFORE trying to modify : " + car.getEngine().getHorsePower());

        engine.setHorsePower(395);
        System.out.println("Horsepower AFTER trying to modify from outside : " + car.getEngine().getHorsePower());

        car.getEngine().setHorsePower(888);
        System.out.println("Horsepower AFTER trying to modify from inside : " + car.getEngine().getHorsePower());
    }
}
