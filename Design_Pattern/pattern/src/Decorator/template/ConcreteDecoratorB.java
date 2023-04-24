package Decorator.template;

public class ConcreteDecoratorB extends Decorator{

    @Override
    public void Operation()
    {
        super.Operation();
        System.out.println("ConcreteDecoratorB::Operation()");
    }


}
