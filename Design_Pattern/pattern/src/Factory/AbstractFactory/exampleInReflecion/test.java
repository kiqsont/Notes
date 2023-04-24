package Factory.AbstractFactory.exampleInReflecion;

import Factory.AbstractFactory.exampleInReflecion.MySQL.MySQLUser;
import Factory.AbstractFactory.exampleInReflecion.pojo.IUser;
import Factory.AbstractFactory.exampleInReflecion.pojo.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
        User user = new User(123,"worker1");
        Class test = Class.forName("Factory.AbstractFactory.exampleInReflecion.MySQL.MySQLUser");
        Constructor test2 = test.getConstructor();
        MySQLUser iUser = (MySQLUser)test2.newInstance();
        User user1 = iUser.getUser(123);
        */
        String dirPath = "Factory.AbstractFactory.exampleInReflecion";
        String db = "MySQL";
        String className = dirPath + "." + db + "." + db + "User";
        Class test = Class.forName(className);
        IUser iUser = (IUser)test.getConstructor().newInstance();
        User user = iUser.getUser(123);
    }
}
