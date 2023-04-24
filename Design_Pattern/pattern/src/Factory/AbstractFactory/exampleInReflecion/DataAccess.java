package Factory.AbstractFactory.exampleInReflecion;

import Factory.AbstractFactory.exampleInReflecion.pojo.IDepartment;
import Factory.AbstractFactory.exampleInReflecion.pojo.IUser;

import java.lang.reflect.InvocationTargetException;

public class DataAccess {
    private static String dirPath = "Factory.AbstractFactory.exampleInReflecion";
    private static String db = "MySQL";
    //private static String db = "SQLite";

    public static IUser createUser() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String className = dirPath + "." + db + "." + db + "User";
        return (IUser)Class.forName(className).getConstructor().newInstance();
    }

    public static IDepartment createDepartment() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String className = dirPath + "." + db + "." + db + "Department";
        return (IDepartment) Class.forName(className).getConstructor().newInstance();
    }
}
