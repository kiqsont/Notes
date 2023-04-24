package Factory.AbstractFactory.example;

import Factory.AbstractFactory.example.pojo.Department;
import Factory.AbstractFactory.example.pojo.IDepartment;
import Factory.AbstractFactory.example.pojo.IUser;
import Factory.AbstractFactory.example.pojo.User;

import javax.xml.crypto.Data;

public class test2 {
    public static void main(String[] args) {
        User user = new User(9,"kiqsont");
        Department department = new Department(2,"department2");

        IUser iUser = DataAccess.createUser();
        IDepartment iDepartment = DataAccess.createDepartment();

        iUser.Insert(user);
        System.out.println("get a user:" + iUser.getUser(123) + "\n");

        iDepartment.Insert(department);
        System.out.println("get a department:" + iDepartment.getDepartment(1) + "\n");
    }
}
