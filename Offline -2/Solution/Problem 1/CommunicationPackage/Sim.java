package CommunicationPackage;

public class Sim implements CommunicationChannel{

    double commModulecost;
    double yearlyCommCost;

    public Sim(){
        setModuleCost(200);
        setYearlyCost(3000);
    }

    @Override
    public double getCost() {
        return (getModuleCost() + getYearlyCost());
    }

    @Override
    public double getModuleCost() {
        return commModulecost;
    }

    @Override
    public void setModuleCost(double moduleCost) {
        commModulecost = moduleCost;
    }

    @Override
    public double getYearlyCost() {
        return yearlyCommCost;
    }

    @Override
    public void setYearlyCost(double yearlyCost) {
        yearlyCommCost = yearlyCost;
    }

    @Override
    public void print() {
        System.out.println("Communication Channel: Sim card");
    }
}
