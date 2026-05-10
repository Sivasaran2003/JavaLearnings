package lld.behaviouralPatterns.observerPattern;

public class Mobile implements Observer{
    private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }

    void display() {
        System.out.println("Mobile : Current Weather " + weather);
    }
}
