package command.impl;

import command.Command;
import iterator.Car;

import java.io.PrintWriter;

public class RowWriteCommand implements Command {
    @Override
    public void execute(Car car, PrintWriter printWriter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Марка: ").append(car.getBrand()).append("\n");
        stringBuilder.append("Модели:\n\t");
        for (String model : car.getModelsArray()) {
            stringBuilder.append(model).append("\n\t");
        }
        String result = stringBuilder.toString();

        printWriter.print(result);
        printWriter.close();

        System.out.println("RowWriter:\n" + result + "\n");
    }
}
