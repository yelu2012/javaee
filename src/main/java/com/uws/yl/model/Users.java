package com.uws.yl.model;

/**
 * @author yelu
 * @ClassName Users
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/17 0017下午 3:08
 */
public class Users {

    private String id;

    private String email;

    private String userName;

    private String passwordHash;

    private String roleId;

    public String getId() {
        return id;
    }

    public Users setId(String id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Users setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Users setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Users setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public Users setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }
}
