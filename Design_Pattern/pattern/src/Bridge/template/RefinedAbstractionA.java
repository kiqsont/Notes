package Bridge.template;

public class RefinedAbstractionA extends Abstraction{
    @Override
    public void Operation()
    {
        System.out.println("RefinedAbstractA tries to use operation method");
        implementor.Operation();
    }
}
