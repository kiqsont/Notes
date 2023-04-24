package Factory.AbstractFactory.example;

import Factory.AbstractFactory.example.MySQL.MySQLDepartment;
import Factory.AbstractFactory.example.MySQL.MySQLUser;
import Factory.AbstractFactory.example.SQLite.SQLiteDepartment;
import Factory.AbstractFactory.example.SQLite.SQLiteUser;
import Factory.AbstractFactory.example.pojo.IDepartment;
import Factory.AbstractFactory.example.pojo.IUser;

public class DataAccess {
    private static String db = "MySQL";
    //private static String db = "SQLite";

    public static IUser createUser()
    {
        IUser result = null;

        switch (db)
        {
            case "MySQL":result = new MySQLUser();break;
            case "SQLite":result = new SQLiteUser();break;
        }

        return result;
    }

    public static IDepartment createDepartment()
    {
        IDepartment result = null;

        switch (db)
        {
            case "MySQL":result = new MySQLDepartment();break;
            case "SQLite":result = new SQLiteDepartment();break;
        }

        return result;
    }
}
