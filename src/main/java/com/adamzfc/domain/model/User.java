package com.adamzfc.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by adamzfc on 4/8/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseEntity {
    private String username;

    private String password;

    private String salt;

    private String email;

    private boolean disabled;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "lastTime")
    private Date lastTime;

    public boolean isRoot(){
        return "root".equals(username);
    }

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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}
