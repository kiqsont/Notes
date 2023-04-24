package Factory.AbstractFactory.example.MySQL;

import Factory.AbstractFactory.example.pojo.IDepartment;
import Factory.AbstractFactory.example.pojo.IFactory;
import Factory.AbstractFactory.example.pojo.IUser;

public class MySQLFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new MySQLUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new MySQLDepartment();
    }
}
