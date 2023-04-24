package Decorator.example;

public class Decorator extends People{

    protected People people;

    public void setDecorator(People people) {
        this.people = people;
    }

    @Override
    public void show()
    {
        people.show();
    }
}
