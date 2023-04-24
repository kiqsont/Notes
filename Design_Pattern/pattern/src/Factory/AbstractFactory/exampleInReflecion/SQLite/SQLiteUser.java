package Factory.AbstractFactory.exampleInReflecion.SQLite;

import Factory.AbstractFactory.exampleInReflecion.pojo.IUser;
import Factory.AbstractFactory.exampleInReflecion.pojo.User;

public class SQLiteUser implements IUser {
    @Override
    public void Insert(User user) {
        System.out.println("SQLite insert a user");
    }

    @Override
    public User getUser(int id) {
        System.out.println("SQLite get a user by id:" + id);
        return null;
    }
}
