package ChainOfResponsibility.template;

public class ConcreteHandlerC extends Handler{
    @Override
    public void HandleRequest(int request) {
            System.out.println(getClass().getName() + " handle " + request);

    }
}
