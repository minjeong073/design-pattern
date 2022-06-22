package strategy.ex01;

public class DecoyDuck extends Duck {

    @Override
    public void quack() {
        // override to do nothing
    }

    @Override
    public void fly() {
        // override to do nothing
    }

    @Override
    public void display() {
        System.out.println("Display DecoyDuck");
    }
}
