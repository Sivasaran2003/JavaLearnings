package lld.behaviouralPatterns.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    List<Observer> observerList = new ArrayList<>();
    String weather;

    public void setWeather(String newWeather) {
        this.weather = newWeather;
        updateAllObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAllObservers() {
        for(Observer o : observerList) {
            o.update(weather);
        }
    }
}
