package DisplayPackage;

public class LCDPanel implements Display{

    double cost;

    public LCDPanel(){
        setCost(10000);
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
        System.out.println("Display: LCD Panel");
    }
}
