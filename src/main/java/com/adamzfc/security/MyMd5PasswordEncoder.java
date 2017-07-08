package com.adamzfc.security;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyMd5PasswordEncoder extends Md5PasswordEncoder {

    @Override
    protected String mergePasswordAndSalt(String password, Object salt, boolean strict) {
        if (password == null) {
            password = "";
        }


        if ((salt == null) || "".equals(salt)) {
            return password;
        }
        else {
            return password + salt.toString();
        }
    }
}
