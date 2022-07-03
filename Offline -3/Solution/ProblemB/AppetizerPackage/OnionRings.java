package AppetizerPackage;

import BurgerPackage.Burger;

public class OnionRings extends AppetizerDecorator{

    private double ORprice;

    public OnionRings(Burger newBurger) {
        super(newBurger);
        setORPrice(80);
    }

    @Override
    public String prepareBurger() {
        return super.prepareBurger()+"[Onion Rings Added]";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + ORprice;
    }

    private void setORPrice(double ORprice) {
        this.ORprice = ORprice;
    }
}
