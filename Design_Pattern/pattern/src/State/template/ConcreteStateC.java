package State.template;

public class ConcreteStateC extends State{
    @Override
    public void Handle(Context context) {
        System.out.println("Final State");
    }
}
