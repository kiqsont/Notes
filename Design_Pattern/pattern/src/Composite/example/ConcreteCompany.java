package Composite.example;

import java.util.ArrayList;

public class ConcreteCompany extends Company{

    private ArrayList<Company> children = new ArrayList<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void Add(Company company) {
        children.add(company);
    }

    @Override
    public void Remove(Company company) {
        children.remove(company);
    }

    @Override
    public void Display(int depth) {
        System.out.println(getPrefix(depth) + name);
        for(Company company:children)
        {
            company.Display(depth + 1);
        }
    }

    @Override
    public void LineOfDuty() {
        for(Company company:children)
        {
            company.LineOfDuty();
        }
    }
}
