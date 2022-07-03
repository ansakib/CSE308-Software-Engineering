package CheesePackage;

import BurgerPackage.Burger;

public class Cheese extends CheeseDecorator {

    private double cheesePrice;

    public Cheese(Burger newBurger) {
        super(newBurger);
        setCheesePrice(100);
    }

    @Override
    public String prepareBurger() {
        return super.prepareBurger()+"[Cheese Added]";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + cheesePrice;
    }

    public void setCheesePrice(double cheesePrice) {
        this.cheesePrice = cheesePrice;
    }
}
