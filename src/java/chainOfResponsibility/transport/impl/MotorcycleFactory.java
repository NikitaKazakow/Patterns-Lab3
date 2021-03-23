package chainOfResponsibility.transport.impl;

import chainOfResponsibility.transport.Transport;
import chainOfResponsibility.transport.TransportFactory;

public class MotorcycleFactory implements TransportFactory {
    @Override
    public Transport createInstance(String modelName, int modelsCount) {
        return new Motorcycle(modelName, modelsCount);
    }
}
