package ProcessorPackage;

public class RaspberryPi implements Processor{

    double cost;

    public RaspberryPi(){
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
        System.out.println("Processor: Raspberry Pi");
    }
}
