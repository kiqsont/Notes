package Composite.example;

public class FinanceDepartment extends Company{
    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void Add(Company company) {

    }

    @Override
    public void Remove(Company company) {

    }

    @Override
    public void Display(int depth) {
        System.out.println(getPrefix(depth) + name);
    }

    @Override
    public void LineOfDuty() {
        System.out.println(name + " 负责财务管理");
    }
}
