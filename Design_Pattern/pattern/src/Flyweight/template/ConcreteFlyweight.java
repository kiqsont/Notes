package Flyweight.template;

public class ConcreteFlyweight extends Flyweight{
    @Override
    public void Operation(int extrinsicState) {
        System.out.println("Concrete Flyweight:" + extrinsicState);
    }
}
