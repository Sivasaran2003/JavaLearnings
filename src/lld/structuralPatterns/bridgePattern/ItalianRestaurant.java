package lld.structuralPatterns.bridgePattern;

public class ItalianRestaurant extends Restaurant{
    public ItalianRestaurant(Pizza pizza) {
        super(pizza);
    }
    @Override
    void addSauce() {
        pizza.sauce = "Italian sauce";
    }

    @Override
    void addToppings() {
        pizza.toppings = "Italian toppings";
    }

    @Override
    void makeCrust() {
        pizza.crust = "Italian crust";
    }
}
