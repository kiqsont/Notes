package Factory.AbstractFactory.example;

import Factory.AbstractFactory.example.SQLite.SQLiteFactory;
import Factory.AbstractFactory.example.pojo.*;

public class test {
    public static void main(String[] args) {
        User user = new User(123,"worker_xixi");
        Department department = new Department(1,"departmentA");

        //IFactory factory = new MySQLFactory();
        IFactory factory = new SQLiteFactory();

        System.out.println("User test");
        IUser iUser = factory.createUser();
        iUser.Insert(user);
        System.out.println("get a user:" + iUser.getUser(123) + "\n");

        System.out.println("Department test");
        IDepartment iDepartment = factory.createDepartment();
        iDepartment.Insert(department);
        System.out.println("get a department:" + iDepartment.getDepartment(1) + "\n");
    }
}
