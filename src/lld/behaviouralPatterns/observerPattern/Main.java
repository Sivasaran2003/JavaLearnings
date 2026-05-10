package lld.behaviouralPatterns.observerPattern;

public class Main {
    static void main() {
        WeatherStation weatherStation = new WeatherStation();

        Observer phoneDisplay = new Mobile();
        Observer tvDisplay = new Television();

        // Register observers
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);

        // Simulating weather changes
        weatherStation.setWeather("Sunny");
        weatherStation.setWeather("Rainy");
        weatherStation.setWeather("Cloudy");

        // Remove one observer
        weatherStation.removeObserver(tvDisplay);

        // Notify remaining observer
        weatherStation.setWeather("Windy");
    }
}

/**
 * Observer Design Pattern is a behavioral pattern that creates a one-to-many relationship between a subject and its observers. When the subject's state changes, all dependent observers are notified and updated automatically, ensuring synchronized communication.
 *
 * Enables automatic updates to multiple objects when one object changes, useful for event-driven or publish-subscribe systems.
 * Promotes loose coupling between the subject and its observers, improving flexibility and maintainability.
 * Example: A YouTube channel (Subject) notifies all its subscribers (Observers) whenever a new video is uploaded.
 */