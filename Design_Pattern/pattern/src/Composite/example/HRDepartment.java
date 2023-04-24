package Composite.example;

public class HRDepartment extends Company{
    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void Add(Company company) {}

    @Override
    public void Remove(Company company) {

    }

    @Override
    public void Display(int depth) {
        System.out.println(getPrefix(depth) + name);
    }

    @Override
    public void LineOfDuty() {
        System.out.println(name + " 负责员工招聘和培训");
    }
}
