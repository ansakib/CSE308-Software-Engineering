package DrinkPackage;

import BurgerPackage.Burger;
import BurgerPackage.Decorator;

public abstract class DrinkDecorator extends Decorator {
    public DrinkDecorator(Burger newBurger) {
        super(newBurger);
    }
}
