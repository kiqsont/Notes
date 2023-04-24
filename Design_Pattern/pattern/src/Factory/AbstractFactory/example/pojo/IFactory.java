package Factory.AbstractFactory.example.pojo;

public interface IFactory {
    IUser createUser();

    IDepartment createDepartment();
}
