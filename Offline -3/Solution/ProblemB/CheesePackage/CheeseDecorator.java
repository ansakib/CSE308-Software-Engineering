package CheesePackage;

import BurgerPackage.Burger;
import BurgerPackage.Decorator;

public abstract class CheeseDecorator extends Decorator {
    public CheeseDecorator(Burger newBurger) {
        super(newBurger);
    }
}
