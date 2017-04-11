package com.adamzfc.domain.model;

import java.util.Date;

/**
 * Created by adamzfc on 4/8/17.
 */
public class User extends BaseEntity {
    private String username;

    private String password;

    private String salt;

    private String email;

    private boolean disabled;

    private Date createTime;

    private Date lastTime;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getEmail() {
        return email;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }
}
