package SystemPackage;

public class Application implements Components{

    double cost;

    public Application(){
        setCost(15000);
    }


    public double getCost() {
        return cost;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public void print() {
        System.out.println("Application Installed");
    }
}
