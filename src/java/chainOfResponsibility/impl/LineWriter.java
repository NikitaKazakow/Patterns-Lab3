package chainOfResponsibility.impl;

import chainOfResponsibility.BaseChainOfResponsibility;
import iterator.Transport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineWriter extends BaseChainOfResponsibility {
    @Override
    public void print(Transport transport) throws IOException {
        if (transport.getModelsCount() <= 3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Марка: ").append(transport.getBrand()).append(" ");
            stringBuilder.append("Модели: ");
            for (String model : transport.getModelsArray()) {
                stringBuilder.append(model).append(" ");
            }
            String result = stringBuilder.toString();
            Files.writeString(Path.of("src/resources/chainOfResponsibility/line_"
                    + transport.getBrand() + ".txt"), result);
            System.out.println("LineWriter:\n" + result + "\n");
        }
        else {
            super.next.print(transport);
        }
    }
}
