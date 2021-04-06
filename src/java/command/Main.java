package command;

import command.impl.LineWriteCommand;
import command.impl.RowWriteCommand;
import iterator.exception.DuplicateModelNameException;
import iterator.exception.NoSuchModelNameException;
import iterator.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try {
            Car car = new Car("Mitsubishi", 3);

            car.setModelName("Модель 1", "Lancer Evo X");
            car.setModelName("Модель 2", "L200");
            car.setModelName("Модель 3", "Galant");

            car.setPrintCommand(new LineWriteCommand());
            car.print(new PrintWriter(new FileWriter("src/resources/command/line_" + car.getBrand() + ".txt")));

            car.setPrintCommand(new RowWriteCommand());
            car.print(new PrintWriter(new FileWriter("src/resources/command/row_" + car.getBrand() + ".txt")));

        } catch (NoSuchModelNameException | DuplicateModelNameException | IOException e) {
            e.printStackTrace();
        }
    }
}
