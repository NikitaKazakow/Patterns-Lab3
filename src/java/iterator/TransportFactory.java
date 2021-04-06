package iterator;

public interface TransportFactory {
    Transport createInstance(String modelName, int modelsCount);
}
