package lld.behaviouralPatterns.observerPattern;

public class Television implements Observer{

    private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }

    void display() {
        System.out.println("Television : Current Weather " + weather);
    }
}
