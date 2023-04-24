package Factory.AbstractFactory.exampleInReflecion.MySQL;

import Factory.AbstractFactory.exampleInReflecion.pojo.IDepartment;
import Factory.AbstractFactory.exampleInReflecion.pojo.IFactory;
import Factory.AbstractFactory.exampleInReflecion.pojo.IUser;

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
