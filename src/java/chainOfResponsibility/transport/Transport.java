package chainOfResponsibility.transport;

import chainOfResponsibility.transport.exception.DuplicateModelNameException;
import chainOfResponsibility.transport.exception.NoSuchModelNameException;

public interface Transport {

    String getBrand();

    void setBrand(String brand);

    void setModelName(String modelName, String newModelName) throws NoSuchModelNameException, DuplicateModelNameException;

    String [] getModelsArray();

    double getPriceByModelName(String modelName) throws NoSuchModelNameException;

    void setPriceByModelName(double price, String modelName) throws NoSuchModelNameException;

    double[] getPrices();

    void addModelNameAndPrice(String modelName, double price)throws DuplicateModelNameException;

    void deleteModel(String modelName) throws NoSuchModelNameException;

    int getModelsCount();

    Transport clone() throws CloneNotSupportedException;
}
