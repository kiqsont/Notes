package Observer;

public class test {
    public static void main(String[] args) {
        ConcreteSubject boss = new ConcreteSubject();
        boss.setSubjectMsg("Deduct your salary");
        ConcreteSubject reception = new ConcreteSubject();
        reception.setSubjectMsg("Run!");

        ConcreteObserver worker1 = new ConcreteObserver("worker1");
        ConcreteObserver worker2 = new ConcreteObserver("worker2");
        ConcreteObserver worker3 = new ConcreteObserver("worker3");

        boss.Append(worker1);
        boss.Append(worker2);
        boss.Notify();

        System.out.println("===========================");

        reception.Append(worker3);
        reception.Notify();
    }
}
