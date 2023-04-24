package Bridge.template;

public class test {
    public static void main(String[] args) {
        Abstraction ab = new RefinedAbstractionA();
        ab.setImplementor(new ConcreteImplementA());
        ab.Operation();

        ab.setImplementor(new ConcreteImplementB());
        ab.Operation();

        System.out.println("----------------");

        ab = new RefinedAbstractionB();
        ab.setImplementor(new ConcreteImplementA());
        ab.Operation();

        ab.setImplementor(new ConcreteImplementB());
        ab.Operation();
    }
}
