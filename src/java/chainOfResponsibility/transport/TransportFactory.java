package chainOfResponsibility.transport;

public interface TransportFactory {
    Transport createInstance(String modelName, int modelsCount);
}
