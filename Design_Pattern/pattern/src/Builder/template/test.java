package Builder.template;

public class test {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builderA = new ConcreteBuilderA();
        Builder builderB = new ConcreteBuilderB();

        System.out.println("In BuilderA");
        director.useBuilder(builderA);
        Product p1 = builderA.getProduct();
        p1.Show();

        System.out.println("In BuilderB");
        director.useBuilder(builderB);
        Product p2 = builderB.getProduct();
        p2.Show();
    }
}
