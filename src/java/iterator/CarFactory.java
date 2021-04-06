package iterator;

public class CarFactory implements TransportFactory {
    @Override
    public Transport createInstance(String modelName, int modelsCount) {
        return new Car(modelName, modelsCount);
    }
}
