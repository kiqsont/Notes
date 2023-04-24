package Facade;

public class Facade {
    subSystem1 system1;
    subSystem2 system2;
    subSystem3 system3;
    subSystem4 system4;

    public Facade() {
        system1 = new subSystem1();
        system2 = new subSystem2();
        system3 = new subSystem3();
        system4 = new subSystem4();
    }

    public void MethodA()
    {
        // Method GroupA
        system1.Method1();
        system2.Method2();
    }

    public void MethodB()
    {
        system3.Method3();
        system2.Method2();
        system4.Method4();
    }
}
