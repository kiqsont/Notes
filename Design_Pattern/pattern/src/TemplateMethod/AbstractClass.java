package TemplateMethod;

public abstract class AbstractClass {

    public void TemplateMethod()
    {
        System.out.println("Try to call TemplateMethod()");
        PrimitiveOperation1();
        PrimitiveOperation2();
        System.out.println("");
    }

    public abstract void PrimitiveOperation1();

    public abstract void PrimitiveOperation2();
}
