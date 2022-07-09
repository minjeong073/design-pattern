package factory.abstractFactory;

/*
Factory Method 소스코드에서 같은 CheesePizza 여도 지역에 따라 재료가 달라지는 코드가 추가되는 경우,
지역에 따른 Factory 를 만들어 Pizza 의 subclass(e.g. CheesePizza) 에 넣어주어 사용하는 식으로
Abstract Factory Pattern 을 활용할 수 있음
 */

class Dough {}
class Sauce {}
class Cheese {}
class Veggies {}
class Pepperoni {}
class Clams {}

interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
}

class ThinCrustDough extends Dough {}
class MarinaraSauce extends Sauce {}
class ReggianoCheese extends Cheese {}
class SlicedPepperoni extends Pepperoni {}
class FreshClams extends Clams {}

class NYPizzaIngredientFactory implements PizzaIngredientFactory {


    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[0];
    }

//    @Override
//    public Veggies[] createVeggies() {
//        Veggies veggies[] = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
//        return veggies;
//    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}

abstract class Pizza {
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();
    void bake() {}
    void cut() {}
    void box() {}

}

class CheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }


    @Override
    void prepare() {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        veggies = ingredientFactory.createVeggies();
        cheese = ingredientFactory.createCheese();
        pepperoni = ingredientFactory.createPepperoni();
        clams = ingredientFactory.createClam();
    }
}

class VeggiePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }


    @Override
    void prepare() {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        veggies = ingredientFactory.createVeggies();
        cheese = ingredientFactory.createCheese();
        pepperoni = ingredientFactory.createPepperoni();
        clams = ingredientFactory.createClam();
    }
}

class CalmPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public CalmPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }


    @Override
    void prepare() {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        veggies = ingredientFactory.createVeggies();
        cheese = ingredientFactory.createCheese();
        pepperoni = ingredientFactory.createPepperoni();
        clams = ingredientFactory.createClam();
    }
}

class PepperoniPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }


    @Override
    void prepare() {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        veggies = ingredientFactory.createVeggies();
        cheese = ingredientFactory.createCheese();
        pepperoni = ingredientFactory.createPepperoni();
        clams = ingredientFactory.createClam();
    }
}

abstract class PizzaStore {
    Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}

class NYPizzaStore extends PizzaStore {

    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory
            = new NYPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
        } else if (item.equals("veggie")) {
            pizza = new VeggiePizza(ingredientFactory);
        } else if (item.equals("clam")) {
            pizza = new CalmPizza(ingredientFactory);
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
        }
        return pizza;
    }
}
