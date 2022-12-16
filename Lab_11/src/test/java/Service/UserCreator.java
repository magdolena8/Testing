package Service;

import Model.User;

public class UserCreator {
    private static final String USER_NAME="aw3";
    private static final String USER_PASSWORD="naziwin";
    public static User createUser(){
        return new User(USER_NAME,USER_PASSWORD);
    }
}
