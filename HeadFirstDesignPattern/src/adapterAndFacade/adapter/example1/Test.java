package adapterAndFacade.adapter.example1;

public class Test {
    public static void main(String[] args) {

        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says ...");
        turkey.gobble();
        turkey.fly();


    }
}
