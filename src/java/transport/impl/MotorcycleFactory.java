package transport.impl;

import transport.Transport;
import transport.TransportFactory;

public class MotorcycleFactory implements TransportFactory {
    @Override
    public Transport createInstance(String modelName, int modelsCount) {
        return new Motorcycle(modelName, modelsCount);
    }
}
