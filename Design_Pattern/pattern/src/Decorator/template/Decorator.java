package Decorator.template;

public class Decorator extends Component{

    protected Component component;

    public void setDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void Operation() {
        component.Operation();
    }
}
