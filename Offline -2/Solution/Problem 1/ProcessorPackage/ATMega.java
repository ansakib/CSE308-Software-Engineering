package ProcessorPackage;

public class ATMega implements Processor{
    double cost;
    public ATMega(){
        setCost(800);

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
        System.out.println("Processor: ATMega32");
    }
}
