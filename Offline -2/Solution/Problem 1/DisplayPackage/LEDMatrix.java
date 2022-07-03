package DisplayPackage;

public class LEDMatrix implements Display{

    double cost;

    public LEDMatrix(){
        setCost(5000);
    }
    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public void print() {
        System.out.println("Display: LED Matrix");
    }
}
