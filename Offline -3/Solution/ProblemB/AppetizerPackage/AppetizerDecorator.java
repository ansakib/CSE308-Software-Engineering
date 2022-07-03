package AppetizerPackage;

import BurgerPackage.Burger;
import BurgerPackage.Decorator;

public abstract class AppetizerDecorator extends Decorator {
    public AppetizerDecorator(Burger newBurger) {
        super(newBurger);
    }
}
