package Composite.example;

public abstract class Company {
    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void Add(Company company);
    public abstract void Remove(Company company);
    public abstract void Display(int depth);
    public abstract void LineOfDuty();

    public String getPrefix(int num)
    {
        String str = new String("-");
        for(int i = 1;i < num;i++)
            str += "--";
        return str;
    }
}
