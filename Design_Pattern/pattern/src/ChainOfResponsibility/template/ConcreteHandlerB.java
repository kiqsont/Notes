package ChainOfResponsibility.template;

public class ConcreteHandlerB extends Handler{
    @Override
    public void HandleRequest(int request) {
        if(request >= 10 && request < 20)
        {
            System.out.println(getClass().getName() + " handle " + request);
        }
        else
        {
            successor.HandleRequest(request);
        }
    }
}
