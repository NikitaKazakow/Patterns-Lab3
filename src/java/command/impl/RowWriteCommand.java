package command.impl;

import transport.impl.Car;
import command.Command;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class RowWriteCommand implements Command {
    @Override
    public void execute(Car car, FileOutputStream outputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Марка: ").append(car.getBrand()).append("\n");
        stringBuilder.append("Модели:\n\t");
        for (String model : car.getModelsArray()) {
            stringBuilder.append(model).append("\n\t");
        }
        String result = stringBuilder.toString();

        PrintStream printStream = new PrintStream(outputStream);
        printStream.print(result);

        System.out.println("RowWriter:\n" + result + "\n");
    }
}
