package strategy.ex03.duck;

import strategy.ex03.flybehavior.FlyNoWay;
import strategy.ex03.quackbehavior.Squeak;

public class RubberDuck extends Duck{

    public RubberDuck() {
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("Display RedheadDuck");
    }
}
