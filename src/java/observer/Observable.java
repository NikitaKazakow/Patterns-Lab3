package observer;

public interface Observable<T> {
    void registerObserver(Observer<T> o);
    void removeObserver(Observer<T> o);
    void notifyObservers();
}
