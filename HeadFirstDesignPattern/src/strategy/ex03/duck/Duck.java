package strategy.ex03.duck;

import strategy.ex03.flybehavior.FlyBehavior;
import strategy.ex03.quackbehavior.QuackBehavior;

public abstract class Duck {
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("Swim");
    }

    public abstract void display();


}
