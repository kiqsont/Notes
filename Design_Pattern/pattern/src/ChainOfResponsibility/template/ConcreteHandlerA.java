package ChainOfResponsibility.template;

public class ConcreteHandlerA extends Handler{
    @Override
    public void HandleRequest(int request) {
        if(request >= 0 && request < 10)
        {
            System.out.println(getClass().getName() + " handle " + request);
        }
        else
        {
            successor.HandleRequest(request);
        }
    }
}
