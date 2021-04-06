package iterator;

import iterator.exception.DuplicateModelNameException;
import iterator.exception.NoSuchModelNameException;

public class Main {
    public static void main(String[] args) {
        try {
            Car car = new Car("Mitsubishi", 3);

            car.setModelName("Модель 1", "Lancer Evo X");
            car.setModelName("Модель 2", "L200");
            car.setModelName("Модель 3", "Galant");
            car.addModelNameAndPrice("Pajero Sport", 1500000);

            for (Car.Model model : car) {
                System.out.println(model);
            }

        } catch (NoSuchModelNameException | DuplicateModelNameException e) {
            e.printStackTrace();
        }
    }
}
