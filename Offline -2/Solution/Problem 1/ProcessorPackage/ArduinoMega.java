package ProcessorPackage;

public class ArduinoMega implements Processor{

    double cost;

    public ArduinoMega(){
        setCost(1000);
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
        System.out.println("Processor: Arduino Mega");
    }
}
