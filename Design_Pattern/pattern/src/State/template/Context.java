package State.template;

public class Context {
    private State state;

    Context()
    {
        state = new ConcreteStateA();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void Request()
    {
        state.Handle(this);
    }
}
