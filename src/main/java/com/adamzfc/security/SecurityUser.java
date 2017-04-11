package com.adamzfc.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by adamzfc on 4/8/17.
 */
public class SecurityUser extends User {
    private int uid;
    private String salt;
    private String email;

    public SecurityUser(int uid, String username, String password, boolean enabled, boolean accountNonExpired,
                        boolean credentialsNonExpired, boolean accountNonLocked,
                        Collection<? extends GrantedAuthority> authorities, String salt, String email) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.salt = salt;
        this.uid = uid;
        this.email = email;
    }

    public int getUid() {
        return uid;
    }

    public String getSalt() {
        return salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
