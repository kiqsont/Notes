package Mediator;

public class test {
    public static void main(String[] args) {
        ConcreteMediator m = new ConcreteMediator();
        ConcreteColleagueA a = new ConcreteColleagueA(m);
        ConcreteColleagueB b = new ConcreteColleagueB(m);

        m.setConcreteColleagueA(a);
        m.setConcreteColleagueB(b);

        a.Send("here is a");

        b.Send("here is b");
    }
}
