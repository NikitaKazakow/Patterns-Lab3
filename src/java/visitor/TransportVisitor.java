package visitor;

import iterator.Car;
import iterator.Motorcycle;

public interface TransportVisitor {

    void visitCar(Car car);
    void visitMotorcycle(Motorcycle motorcycle);

}
