package DrinkPackage;

import BurgerPackage.Burger;

public class Coke extends DrinkDecorator{

    private double cokePrice;

    public Coke(Burger newBurger) {
        super(newBurger);
        setCokePrice(20);
    }

    @Override
    public String prepareBurger() {
        return super.prepareBurger()+"[Coke Added]";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + cokePrice;
    }

    private void setCokePrice(double cokePrice){
        this.cokePrice =  cokePrice;
    }
}
