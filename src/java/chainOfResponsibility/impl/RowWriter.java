package chainOfResponsibility.impl;

import chainOfResponsibility.BaseChainOfResponsibility;
import transport.Transport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RowWriter extends BaseChainOfResponsibility {
    @Override
    public void print(Transport transport) throws IOException {
        if (transport.getModelsCount() > 3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Марка: ").append(transport.getBrand()).append("\n");
            stringBuilder.append("Модели:\n\t");
            for (String model : transport.getModelsArray()) {
                stringBuilder.append(model).append("\n\t");
            }
            String result = stringBuilder.toString();
            Files.writeString(Path.of("src/resources/chainOfResponsibility/row_"
                    + transport.getBrand() + ".txt"), stringBuilder.toString());
            System.out.println("RowWriter:\n" + result + "\n");
        }
        else {
            super.next.print(transport);
        }
    }
}
