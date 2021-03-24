package command;

import transport.impl.Car;

import java.io.FileOutputStream;

public interface Command {
    void execute(Car car, FileOutputStream outputStream);
}
