package lld.behaviouralPatterns.observerPattern;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void updateAllObservers();
}
