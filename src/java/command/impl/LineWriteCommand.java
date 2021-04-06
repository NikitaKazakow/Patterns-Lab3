package command.impl;

import command.Command;
import iterator.Car;

import java.io.PrintWriter;

public class LineWriteCommand implements Command {
    @Override
    public void execute(Car car, PrintWriter printWriter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Марка: ").append(car.getBrand()).append(" ");
        stringBuilder.append("Модели: ");
        for (String model : car.getModelsArray()) {
            stringBuilder.append(model).append(" ");
        }
        String result = stringBuilder.toString();
        printWriter.print(result);
        printWriter.close();

        System.out.println("LineWriter:\n" + result + "\n");
    }
}
