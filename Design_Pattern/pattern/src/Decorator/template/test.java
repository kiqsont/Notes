package Decorator.template;

public class test {
    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();

        concreteDecoratorA.setDecorator(concreteComponent);
        concreteDecoratorB.setDecorator(concreteDecoratorA);
        concreteDecoratorB.Operation();
    }
}
