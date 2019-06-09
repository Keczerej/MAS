package fitenssclub.database;

import fitenssclub.model.users.User;

public class UserEntity extends DatabaseEntity<User> {

    private UserEntity(){}

    private static UserEntity instance = null;

    public static UserEntity getInstance() {
        if(instance == null)
            instance = new UserEntity();
        return instance;
    }

}
