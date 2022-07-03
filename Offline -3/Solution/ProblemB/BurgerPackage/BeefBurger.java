package BurgerPackage;

public class BeefBurger implements Burger{

    double price;

    public BeefBurger(){
        setPrice(200);
    }

    @Override
    public String prepareBurger() {
        return "Beef Burger";
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
