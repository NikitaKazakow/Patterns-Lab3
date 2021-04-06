package memento;

import iterator.Car;
import iterator.exception.DuplicateModelNameException;
import iterator.exception.NoSuchModelNameException;

public class Main {
    public static void main(String[] args) {
        try {
            Car car = new Car("Mitsubishi", 1);

            car.setModelName("Модель 1", "Lancer Evo X");

            Car.CarMemento carMemento = car.createMemento();

            System.out.println("Оригинал:\n" + "Марка:\n\t" + car.getBrand());
            for (Car.Model model : car) {
                System.out.println(model.toString());
            }

            car.setBrand("Audi");
            car.addModelNameAndPrice("A6", 2500000);

            System.out.println("\nИзмененный:\n" + "Марка:\n\t" + car.getBrand());
            for (Car.Model model : car) {
                System.out.println(model.toString());
            }

            car = car.setMemento(carMemento);

            System.out.println("\nВосстановленный:\n" + "Марка:\n\t" + car.getBrand());
            for (Car.Model model : car) {
                System.out.println(model.toString());
            }

        } catch (NoSuchModelNameException | DuplicateModelNameException e) {
            e.printStackTrace();
        }
    }
}
