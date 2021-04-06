package visitor;

import iterator.Car;
import iterator.Motorcycle;
import iterator.exception.DuplicateModelNameException;
import iterator.exception.NoSuchModelNameException;

public class Main {
    public static void main(String[] args) {
        try {
            TransportVisitor visitor = new PrintTransportVisitor();

            Car car = new Car("Mitsubishi", 3);
            car.setModelName("Модель 1", "Lancer Evo X");
            car.setModelName("Модель 2", "L200");
            car.setModelName("Модель 3", "Galant");

            Motorcycle motorcycle = new Motorcycle("Honda", 3);
            motorcycle.setModelName("Модель 1", "Super sport");
            motorcycle.setModelName("Модель 2", "Adventure");
            motorcycle.setModelName("Модель 3", "Street");

            car.accept(visitor);
            motorcycle.accept(visitor);

        } catch (NoSuchModelNameException | DuplicateModelNameException e) {
            e.printStackTrace();
        }
    }
}
