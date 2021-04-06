package chainOfResponsibility;

import iterator.Transport;

import java.io.IOException;

public interface ChainOfResponsibility {
    void print(Transport transport) throws IOException;
}
