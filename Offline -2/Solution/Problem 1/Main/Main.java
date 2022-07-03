package Main;

import BuilderPackage.*;
import SystemPackage.QMSystem;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String qmsystemPackage, connectionChannel;
        int displayUnitCount;
        Director director = new Director();

        Scanner sc = new Scanner(System.in);
        System.out.print("Package Name: ");
        qmsystemPackage = sc.nextLine();

        System.out.print("Communication Channel (Wifi/Sim): ");
        connectionChannel = sc.nextLine();

        System.out.print("Number of Display units: ");
        displayUnitCount = sc.nextInt();

        SystemBuilder systemBuilder = null;

        if(qmsystemPackage.equalsIgnoreCase("deluxe"))
        {
            //System.out.println("hello");
            systemBuilder = new DeluxeBuilder(connectionChannel, displayUnitCount);
        }
        else if(qmsystemPackage.equalsIgnoreCase("optimal"))
        {
            systemBuilder = new OptimalBuilder(connectionChannel, displayUnitCount);
        }
        else if(qmsystemPackage.equalsIgnoreCase("poor"))
        {
            systemBuilder = new PoorBuilder(connectionChannel, displayUnitCount);
        }

        director.construct(systemBuilder);

        QMSystem qmSystem = systemBuilder.getSystem();
        qmSystem.show();
        qmSystem.totalCost();
    }

    /*private static SystemBuilder selectBuilder (String qmsystemPackage)
    {
        //System.out.println("hello1");
        //System.out.println(qmsystemPackage);
        if(qmsystemPackage.equalsIgnoreCase("deluxe"))
        {
            //System.out.println("hello");
            return new DeluxeBuilder();
        }
        else if(qmsystemPackage.equalsIgnoreCase("optimal"))
        {
            return new OptimalBuilder();
        }
        else if(qmsystemPackage.equalsIgnoreCase("poor"))
        {
            return new PoorBuilder();
        }
        return null;
    }*/
}
