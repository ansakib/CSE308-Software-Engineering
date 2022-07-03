package BurgerPackage;

public class ChickenBurger implements Burger{

    double price;

    public ChickenBurger(){
        setPrice(150);
    }

    @Override
    public String prepareBurger() {
        return "Chicken Burger";
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
