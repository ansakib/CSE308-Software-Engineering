package BurgerPackage;

public abstract class Decorator implements Burger{

    private Burger newBurger;

    public Decorator(Burger newBurger){
        this.newBurger = newBurger;
    }

    @Override
    public String prepareBurger() {
        return newBurger.prepareBurger();
    }

    @Override
    public double getPrice() {
        return newBurger.getPrice();
    }

    @Override
    public void setPrice(double price) {

    }
}
