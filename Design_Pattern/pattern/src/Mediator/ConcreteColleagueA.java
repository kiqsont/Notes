package Mediator;

public class ConcreteColleagueA extends Colleague{

    public ConcreteColleagueA(Mediator mediator) {
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
