package command;

import iterator.Car;

import java.io.PrintWriter;
import java.io.Serializable;

public interface Command extends Serializable {
    void execute(Car car, PrintWriter outputStream);
}
