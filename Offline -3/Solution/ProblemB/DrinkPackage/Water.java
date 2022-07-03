package DrinkPackage;

import BurgerPackage.Burger;

public class Water extends DrinkDecorator{

    private double waterPrice;

    public Water(Burger newBurger) {
        super(newBurger);
        setWaterPrice(15);
    }

    @Override
    public String prepareBurger() {
        return super.prepareBurger()+"[Water Added]";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + waterPrice;
    }

    private void setWaterPrice(double waterPrice){
        this.waterPrice =  waterPrice;
    }
}
