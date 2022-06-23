package strategy.ex03.duck;

import strategy.ex03.flybehavior.FlyNoWay;
import strategy.ex03.quackbehavior.MuteQuack;

public class DecoyDuck extends Duck{

    public DecoyDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("Display DecoyDuck");
    }
}
