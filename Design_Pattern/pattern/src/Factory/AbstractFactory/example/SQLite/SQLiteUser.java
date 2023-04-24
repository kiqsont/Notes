package Factory.AbstractFactory.example.SQLite;

import Factory.AbstractFactory.example.pojo.IUser;
import Factory.AbstractFactory.example.pojo.User;

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
