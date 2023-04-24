package Composite.template;

public class test {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.Add(new Leaf("Leaf A"));
        root.Add(new Leaf("Leaf B"));

        Composite comp1 = new Composite("Composite X");
        comp1.Add(new Leaf("Leaf XA"));
        comp1.Add(new Leaf("Leaf XB"));
        root.Add(comp1);

        Composite comp2 = new Composite("Composite Y");
        comp2.Add(new Leaf("Leaf YA"));
        comp2.Add(new Leaf("Leaf YB"));
        root.Add(comp2);

        root.Display(1);
    }
}
