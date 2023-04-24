package Mediator;

public class ConcreteColleagueB extends Colleague{

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    public void Send(String msg)
    {
        mediator.Send(msg,this);
    }

    public void aNotify(String msg)
    {
        System.out.println(getClass().getName() + " has receive " + msg);
    }
}
