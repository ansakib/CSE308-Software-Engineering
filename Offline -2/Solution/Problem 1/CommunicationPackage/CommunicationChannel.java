package CommunicationPackage;

import SystemPackage.Components;

public interface CommunicationChannel extends Components {

    double getCost();
    double getModuleCost();
    void setModuleCost(double moduleCost);

    double getYearlyCost();
    void setYearlyCost(double yearlyCost);
}
