package Factory.AbstractFactory.exampleInReflecion.SQLite;

import Factory.AbstractFactory.exampleInReflecion.pojo.Department;
import Factory.AbstractFactory.exampleInReflecion.pojo.IDepartment;

public class SQLiteDepartment implements IDepartment {
    @Override
    public void Insert(Department department) {
        System.out.println("SQLite insert a department");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("SQLite get a department by id:" + id);
        return null;
    }
}
