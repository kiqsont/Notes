package Composite.example;

public class test {
    public static void main(String[] args) {
        ConcreteCompany root = new ConcreteCompany("总公司");
        root.Add(new HRDepartment("总公司HR部"));
        root.Add(new FinanceDepartment("总公司财务部"));

        ConcreteCompany comp1 = new ConcreteCompany("子公司1");
        comp1.Add(new HRDepartment("子公司1HR部"));
        comp1.Add(new FinanceDepartment("子公司1财务部"));
        root.Add(comp1);

        ConcreteCompany comp2 = new ConcreteCompany("子公司2");
        comp2.Add(new FinanceDepartment("子公司2财务部"));
        root.Add(comp2);

        root.Display(1);
        root.LineOfDuty();
    }
}
