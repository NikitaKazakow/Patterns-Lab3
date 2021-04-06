package chainOfResponsibility;

public abstract class BaseChainOfResponsibility implements ChainOfResponsibility {

    protected BaseChainOfResponsibility next;

    public void setNext(BaseChainOfResponsibility writer) {
        this.next = writer;
    }
}
