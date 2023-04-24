package Factory.AbstractFactory.example.SQLite;

import Factory.AbstractFactory.example.pojo.IDepartment;
import Factory.AbstractFactory.example.pojo.IFactory;
import Factory.AbstractFactory.example.pojo.IUser;

public class SQLiteFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new SQLiteUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new SQLiteDepartment();
    }
}
