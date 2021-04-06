package iterator;

public class MotorcycleFactory implements TransportFactory {
    @Override
    public Transport createInstance(String modelName, int modelsCount) {
        return new Motorcycle(modelName, modelsCount);
    }
}
