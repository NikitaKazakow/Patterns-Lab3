package observer;

import java.util.LinkedList;
import java.util.List;

public class BaseObservable<T> implements Observable<T> {

    private final List<Observer<T>> observers;
    protected T data;

    public BaseObservable() {
        this.observers = new LinkedList<>();
    }

    public BaseObservable(Observer<T> observer) {
        this.observers = new LinkedList<>();
        registerObserver(observer);
    }

    @Override
    public void registerObserver(Observer<T> o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer<T> o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer<T> observer : observers) {
            observer.update(data);
        }
    }
}
