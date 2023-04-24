package ChainOfResponsibility.template;

public class test {
    public static void main(String[] args) {
        ConcreteHandlerA concreteHandlerA = new ConcreteHandlerA();
        ConcreteHandlerB concreteHandlerB = new ConcreteHandlerB();
        ConcreteHandlerC concreteHandlerC = new ConcreteHandlerC();
        concreteHandlerA.setSuccessor(concreteHandlerB);
        concreteHandlerB.setSuccessor(concreteHandlerC);

        int request = 5;
        System.out.println("request:" + request);
        concreteHandlerA.HandleRequest(request);

        request += 10;
        System.out.println("request:" + request);
        concreteHandlerA.HandleRequest(request);

        request += 10;
        System.out.println("request:" + request);
        concreteHandlerA.HandleRequest(request);
    }
}
