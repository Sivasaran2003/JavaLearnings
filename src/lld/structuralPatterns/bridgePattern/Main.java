package lld.structuralPatterns.bridgePattern;

public class Main {
    public static void main() {
        AmericanRestaurant americanRestaurant = new AmericanRestaurant(new VeggiePizza());
        americanRestaurant.deliver();
        americanRestaurant = new AmericanRestaurant(new PepperoniPizza());
        americanRestaurant.deliver();
        ItalianRestaurant italianRestaurant = new ItalianRestaurant(new VeggiePizza());
        italianRestaurant.deliver();
        italianRestaurant = new ItalianRestaurant(new PepperoniPizza());
        italianRestaurant.deliver();
    }
}

/**
 * Bridge pattern splits large hierarchies into separate hierarchies
 * which can be developed independently
 */