package chainOfResponsibility;

import transport.Transport;

import java.io.IOException;

public interface ChainOfResponsibility {
    void print(Transport transport) throws IOException;
}
