package Flyweight.template;

public class UnsharedConcreteFlyweight extends Flyweight{
    @Override
    public void Operation(int extrinsicState) {
        System.out.println("Unshared Concrete Flyweight:" + extrinsicState);
    }
}
