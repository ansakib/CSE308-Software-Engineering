package SystemPackage;

import CommunicationPackage.CommunicationChannel;
import DisplayPackage.Display;
import ProcessorPackage.Processor;

import java.util.ArrayList;

public class QMSystem {
    private ArrayList<Components> compList;
    private int displayUnitCount;

    public QMSystem(){
        compList = new ArrayList<Components>();
    }

    public int getDisplayUnitCount() {
        return displayUnitCount;
    }

    public void setDisplayUnitCount(int displayUnitCount) {
        this.displayUnitCount = displayUnitCount;
    }

    public void addComp(Components comp){
        compList.add(comp);
    }

    public void show(){
        System.out.println();
        System.out.println("Queue Management System Description: ");
        for(Components cmp : compList){
            cmp.print();
        }
        System.out.println("Number of Display Units: " + getDisplayUnitCount());
        System.out.println();
    }

    public void totalCost(){
        System.out.println();
        System.out.println("System Build Receipt:");
        double totCost = 0;
        for(Components cmp : compList){
            if(cmp instanceof Processor){
                System.out.println("Processor * "+getDisplayUnitCount()+" : "+ ((Processor) cmp).getCost()+" * "+getDisplayUnitCount());
                for (int i = 0; i <getDisplayUnitCount(); i++) {
                    totCost += ((Processor) cmp).getCost();
                }
            }
            else if(cmp instanceof Display){
                System.out.println("Display * "+getDisplayUnitCount()+" : "+ ((Display) cmp).getCost()+" * "+getDisplayUnitCount());
                for (int i = 0; i <getDisplayUnitCount(); i++) {
                    totCost += ((Display) cmp).getCost();
                }
            }
            else if(cmp instanceof Application){
                System.out.println("Application : "+ ((Application) cmp).getCost());
                totCost += ((Application) cmp).getCost();
            }
            else if(cmp instanceof CommunicationChannel){
                System.out.println("Communication Channel : "+ ((CommunicationChannel) cmp).getCost());
                totCost += ((CommunicationChannel) cmp).getCost();
            }
        }

        System.out.println();
        System.out.println("Total cost of the System: "+totCost);
    }
}
