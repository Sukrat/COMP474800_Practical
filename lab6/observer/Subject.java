import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this, null);
        }
    }

    public void notifyObservers(Object args) {
        for (Observer observer : observers) {
            observer.update(this, args);
        }
    }
}