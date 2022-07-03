package ProcessorPackage;

import SystemPackage.Components;

public interface Processor extends Components {
    double getCost();
    void setCost(double cost);
}
