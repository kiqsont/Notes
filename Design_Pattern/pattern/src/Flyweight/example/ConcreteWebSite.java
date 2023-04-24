package Flyweight.example;

public class ConcreteWebSite extends WebSite{

    private String name;

    public ConcreteWebSite(String name) {
        this.name = name;
    }

    @Override
    public void Use(User user) {
        System.out.println("It's Concrete WebSite:" + name + " to user:" + user.getUsername());
    }
}
