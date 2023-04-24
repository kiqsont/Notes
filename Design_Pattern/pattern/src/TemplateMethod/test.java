package TemplateMethod;

public class test {
    public static void main(String[] args) {
        AbstractClass class1 = new ConcreteClassA();
        class1.TemplateMethod();

        AbstractClass class2 = new ConcreteClassB();
        class2.TemplateMethod();
    }
}
