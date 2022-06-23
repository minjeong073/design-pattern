package strategy.ex03.flybehavior;

public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
