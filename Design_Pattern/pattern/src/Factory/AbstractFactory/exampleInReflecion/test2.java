package Factory.AbstractFactory.exampleInReflecion;

import Factory.AbstractFactory.exampleInReflecion.pojo.IUser;

import java.lang.reflect.InvocationTargetException;

public class test2 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        IUser iUser = DataAccess.createUser();
        iUser.getUser(9527);
    }
}
