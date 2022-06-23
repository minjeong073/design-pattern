package strategy.ex03.duck;

import strategy.ex03.flybehavior.FlyWithWings;
import strategy.ex03.quackbehavior.Quack;

public class RedheadDuck extends Duck{

    public RedheadDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("Display RedheadDuck");
    }
}
