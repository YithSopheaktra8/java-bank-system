package repository;

import model.SystemUser;

public class SystemUserRepository {
    public static SystemUser getAdminUser(){
        return new SystemUser("admin","password");
    }
}
