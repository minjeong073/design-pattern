package strategy.ex01;

public class RubberDuck extends Duck {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }

    @Override
    public void fly() {
        // override to do nothing
    }

    @Override
    public void display() {
        System.out.println("Display RedheadDuck");
    }
}
