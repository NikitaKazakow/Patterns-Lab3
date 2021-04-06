package visitor;

import iterator.Car;
import iterator.Motorcycle;

public class PrintTransportVisitor implements TransportVisitor {
    @Override
    public void visitCar(Car car) {
        System.out.println("Марка:\n\t" + car.getBrand());
        for (Car.Model model : car) {
            System.out.println(model.toString());
        }
        System.out.print("\n");
    }

    @Override
    public void visitMotorcycle(Motorcycle motorcycle) {
        System.out.println("Марка:\n\t" + motorcycle.getBrand());
        String [] modelNames = motorcycle.getModelsArray();
        double [] prices = motorcycle.getPrices();
        for (int i = 0; i < motorcycle.getModelsCount(); i++) {
            System.out.println("Модель: \"" + modelNames[i] + "\" Цена: \"" + prices[i] + "\"");
        }
        System.out.print("\n");
    }
}
