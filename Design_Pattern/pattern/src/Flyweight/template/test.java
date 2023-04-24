package Flyweight.template;

public class test {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        int extrinsicState = 20;

        Flyweight fx = factory.getFlyweight("X");
        fx.Operation(--extrinsicState);

        Flyweight fy = factory.getFlyweight("Y");
        fy.Operation(--extrinsicState);

        Flyweight fz = factory.getFlyweight("Z");
        fz.Operation(--extrinsicState);

        Flyweight fun = new UnsharedConcreteFlyweight();
        fun.Operation(--extrinsicState);

        Flyweight fk = factory.getFlyweight("K");
        fk.Operation(++extrinsicState);
    }
}
