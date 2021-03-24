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

        BaseChainOfResponsibility chain;
        chain = new LineWriter();
        chain.setNext(new RowWriter());

        try {
            Transport car = TransportManager.createInstance("Mitsubishi", 3);

            car.setModelName("Модель 1", "Lancer Evo X");
            car.setModelName("Модель 2", "L200");
            car.setModelName("Модель 3", "Galant");

            chain.print(car);

            car.addModelNameAndPrice("Pajero Sport", 1500000);

            chain.print(car);

        } catch (NoSuchModelNameException | DuplicateModelNameException | IOException e) {
            e.printStackTrace();
        }
    }
}
