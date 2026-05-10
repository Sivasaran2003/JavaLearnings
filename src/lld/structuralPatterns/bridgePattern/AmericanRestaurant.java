package lld.structuralPatterns.bridgePattern;

public class AmericanRestaurant extends Restaurant{

    public AmericanRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    void addSauce() {
        pizza.sauce = "American sauce";
    }

    @Override
    void addToppings() {
        pizza.toppings = "American toppings";
    }

    @Override
    void makeCrust() {
        pizza.crust = "American crust";
    }
}
