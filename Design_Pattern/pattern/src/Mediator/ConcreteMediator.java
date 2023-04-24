package Mediator;

public class ConcreteMediator extends Mediator{

    private ConcreteColleagueA concreteColleagueA;
    private ConcreteColleagueB concreteColleagueB;

    public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA) {
        this.concreteColleagueA = concreteColleagueA;
    }

    public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB) {
        this.concreteColleagueB = concreteColleagueB;
    }

    @Override
    public void Send(String msg, Colleague colleague) {
        if(colleague.equals(concreteColleagueA))
        {
            concreteColleagueB.aNotify(msg);
        }
        else
        {
            concreteColleagueA.aNotify(msg);
        }
    }
}
