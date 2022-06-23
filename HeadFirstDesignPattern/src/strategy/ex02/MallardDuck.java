package strategy.ex02;

public class MallardDuck extends Duck implements Quackable, Flyable{

    @Override
    public void display() {
        System.out.println("Display MallardDuck");
    }

    @Override
    public void fly() {
        System.out.println("Fly");
    }

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
