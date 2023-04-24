package Factory.AbstractFactory.exampleInReflecion.MySQL;

import Factory.AbstractFactory.exampleInReflecion.pojo.IUser;
import Factory.AbstractFactory.exampleInReflecion.pojo.User;

public class MySQLUser implements IUser {
    @Override
    public void Insert(User user) {
        System.out.println("MySQL insert a user");
    }

    @Override
    public User getUser(int id) {
        System.out.println("MySQL get a user by id:" + id);
        return null;
    }
}
