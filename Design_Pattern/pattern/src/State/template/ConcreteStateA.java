package State.template;

public class ConcreteStateA extends State{
    @Override
    public void Handle(Context context) {
        System.out.println("A to B");
        context.setState(new ConcreteStateB());
    }
}
