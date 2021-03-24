package command.impl;

import transport.impl.Car;
import command.Command;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class LineWriteCommand implements Command {
    @Override
    public void execute(Car car, FileOutputStream outputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Марка: ").append(car.getBrand()).append(" ");
        stringBuilder.append("Модели: ");
        for (String model : car.getModelsArray()) {
            stringBuilder.append(model).append(" ");
        }
        String result = stringBuilder.toString();

        PrintStream printStream = new PrintStream(outputStream);
        printStream.print(result);

        System.out.println("LineWriter:\n" + result + "\n");
    }
}
