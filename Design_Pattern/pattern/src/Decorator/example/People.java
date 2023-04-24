package Decorator.example;

public class People {

    private String peopleName;

    public People(String peopleName) {
        this.peopleName = peopleName;
    }

    public People() {
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public void show()
    {
        System.out.println("People decorator:");
    }
}
