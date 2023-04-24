package Factory.AbstractFactory.exampleInReflecion.SQLite;

import Factory.AbstractFactory.exampleInReflecion.pojo.IDepartment;
import Factory.AbstractFactory.exampleInReflecion.pojo.IFactory;
import Factory.AbstractFactory.exampleInReflecion.pojo.IUser;

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
