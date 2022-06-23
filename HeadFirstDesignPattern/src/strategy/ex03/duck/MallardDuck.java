package strategy.ex03.duck;

import strategy.ex03.flybehavior.FlyWithWings;
import strategy.ex03.quackbehavior.Quack;

public class MallardDuck extends Duck{

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("Display MallardDuck");
    }
}
