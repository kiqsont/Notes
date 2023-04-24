package Factory.AbstractFactory.example.pojo;

import Factory.AbstractFactory.example.pojo.User;

public interface IUser {
    void Insert(User user);

    User getUser(int id);
}
