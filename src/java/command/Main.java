package command;

import transport.exception.DuplicateModelNameException;
import transport.exception.NoSuchModelNameException;
import transport.impl.Car;
import command.impl.LineWriteCommand;
import command.impl.RowWriteCommand;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            Car car = new Car("Mitsubishi", 3);

            car.setModelName("Модель 1", "Lancer Evo X");
            car.setModelName("Модель 2", "L200");
            car.setModelName("Модель 3", "Galant");

            car.setPrintCommand(new LineWriteCommand());
            car.print(new FileOutputStream("src/resources/command/line_"
                    + car.getBrand() + ".txt"));

            car.setPrintCommand(new RowWriteCommand());
            car.print(new FileOutputStream("src/resources/command/row_"
                    + car.getBrand() + ".txt"));

        } catch (NoSuchModelNameException | DuplicateModelNameException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
