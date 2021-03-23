package chainOfResponsibility.transport.impl;

import chainOfResponsibility.transport.Transport;
import chainOfResponsibility.transport.TransportFactory;

public class CarFactory implements TransportFactory {
    @Override
    public Transport createInstance(String modelName, int modelsCount) {
        return new Car(modelName, modelsCount);
    }
}
