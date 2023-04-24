package State.template;

public class ConcreteStateB extends State{
    @Override
    public void Handle(Context context) {
        System.out.println("B to C");
        context.setState(new ConcreteStateC());
    }
}
