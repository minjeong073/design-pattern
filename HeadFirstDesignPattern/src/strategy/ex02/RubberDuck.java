package strategy.ex02;

public class RubberDuck extends Duck implements Quackable{
    @Override
    public void display() {
        System.out.println("Squeak");
    }

    @Override
    public void quack() {
        System.out.println("Display RedheadDuck");
    }
}
