package chainOfResponsibility;

public abstract class BaseChainOfResponsibility implements ChainOfResponsibility {

    protected BaseChainOfResponsibility next;

    public BaseChainOfResponsibility setNext(BaseChainOfResponsibility writer) {
        this.next = writer;
        return writer;
    }
}
