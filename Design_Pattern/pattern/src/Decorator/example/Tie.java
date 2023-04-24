package Decorator.example;

public class Tie extends Decorator{
    @Override
    public void show()
    {
        super.show();
        System.out.println("Dress Tie");
    }
}
