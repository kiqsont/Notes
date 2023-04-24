package Decorator.template;

public class ConcreteDecoratorA extends Decorator{

    @Override
    public void Operation()
    {
        super.Operation();
        System.out.println("ConcreteDecoratorA::Operation()");
    }


}
