package DrinkPackage;

import BurgerPackage.Burger;

public class Coffee extends DrinkDecorator{

    private double coffeePrice;

    public Coffee(Burger newBurger) {
        super(newBurger);
        setCoffePrice(60);
    }

    @Override
    public String prepareBurger() {
        return super.prepareBurger()+"[Coffee Added]";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + coffeePrice;
    }

    private void setCoffePrice(double coffeePrice){
        this.coffeePrice =  coffeePrice;
    }
}
