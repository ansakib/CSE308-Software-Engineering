package AppetizerPackage;

import BurgerPackage.Burger;

public class FrenchFry extends AppetizerDecorator{

    private double FFprice;

    public FrenchFry(Burger newBurger) {
        super(newBurger);
        setFFPrice(100);
    }

    @Override
    public String prepareBurger() {
        return super.prepareBurger()+"[French Fry Added]";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + FFprice;
    }

    private void setFFPrice(double FFprice) {
        this.FFprice = FFprice;
    }
}
