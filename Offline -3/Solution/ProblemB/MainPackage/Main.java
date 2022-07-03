package MainPackage;

import AppetizerPackage.FrenchFry;
import AppetizerPackage.OnionRings;
import BurgerPackage.BeefBurger;
import BurgerPackage.Burger;
import BurgerPackage.VeggiBurger;
import CheesePackage.Cheese;
import DrinkPackage.Coffee;
import DrinkPackage.Coke;
import DrinkPackage.Water;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("========Burger Menu========");
        System.out.println("1. Beef burger with French fry and cheese");
        System.out.println("2. Veggi burger with onion rings and Bottle of Water");
        System.out.println("3. A combo meal with Veggi burger, French Fry and Coke");
        System.out.println("4. A combo meal with Veggi burger, Onion Rings, Coffee and Water");
        System.out.println("5. A Beef burger only");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        Burger burger = null;

        if(option==1){
            burger = new Cheese(new FrenchFry(new BeefBurger()));
        }
        else if(option==2){
            burger = new Water(new OnionRings(new VeggiBurger()));
        }
        else if(option==3){
            burger = new Coke(new FrenchFry(new VeggiBurger()));
        }
        else if(option==4){
            burger = new Water(new Coffee(new OnionRings(new VeggiBurger())));
        }
        else if(option==5){
            burger = new BeefBurger();
        }

        System.out.println(burger.prepareBurger());
        System.out.println(burger.getPrice());

    }
}
