package BurgerPackage;

public class VeggiBurger implements Burger{

    double price;

    public VeggiBurger(){
        setPrice(100);
    }

    @Override
    public String prepareBurger() {
        return "Veggi Burger";
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
