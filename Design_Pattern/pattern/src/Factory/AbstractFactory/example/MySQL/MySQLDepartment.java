package Factory.AbstractFactory.example.MySQL;

import Factory.AbstractFactory.example.pojo.Department;
import Factory.AbstractFactory.example.pojo.IDepartment;

public class MySQLDepartment implements IDepartment {
    @Override
    public void Insert(Department department) {
        System.out.println("MySQL insert a department");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("MySQL get a department by id:" + id);
        return null;
    }
}
