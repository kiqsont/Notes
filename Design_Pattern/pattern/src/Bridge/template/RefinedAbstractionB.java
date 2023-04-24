package Bridge.template;

public class RefinedAbstractionB extends Abstraction{
    @Override
    public void Operation()
    {
        System.out.println("RefinedAbstractB tries to use operation method");
        implementor.Operation();
    }
}
