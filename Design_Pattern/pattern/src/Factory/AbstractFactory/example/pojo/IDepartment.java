package Factory.AbstractFactory.example.pojo;

import Factory.AbstractFactory.example.pojo.Department;

public interface IDepartment {
    void Insert(Department department);

    Department getDepartment(int id);
}
