package chainOfResponsibility;

import chainOfResponsibility.impl.LineWriter;
import chainOfResponsibility.impl.RowWriter;
import chainOfResponsibility.transport.Transport;
import chainOfResponsibility.transport.TransportManager;
import chainOfResponsibility.transport.exception.DuplicateModelNameException;
import chainOfResponsibility.transport.exception.NoSuchModelNameException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        BaseChainOfResponsibility lineWriter, rowWriter;
        lineWriter = new LineWriter();
        rowWriter = lineWriter.setNext(new RowWriter());
        rowWriter.setNext(lineWriter);

        try {
            Transport car = TransportManager.createInstance("Mitsubishi", 3);

            car.setModelName("Модель 1", "Lancer Evo X");
            car.setModelName("Модель 2", "L200");
            car.setModelName("Модель 3", "Galant");

            lineWriter.print(car);
            rowWriter.print(car);

            car.addModelNameAndPrice("Pajero Sport", 1500000);

            lineWriter.print(car);
            rowWriter.print(car);

        } catch (NoSuchModelNameException | DuplicateModelNameException | IOException e) {
            e.printStackTrace();
        }
    }
}
