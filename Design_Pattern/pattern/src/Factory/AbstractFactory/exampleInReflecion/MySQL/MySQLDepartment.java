package Factory.AbstractFactory.exampleInReflecion.MySQL;

import Factory.AbstractFactory.exampleInReflecion.pojo.Department;
import Factory.AbstractFactory.exampleInReflecion.pojo.IDepartment;

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
