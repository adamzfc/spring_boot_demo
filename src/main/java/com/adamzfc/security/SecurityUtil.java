package com.adamzfc.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by adamzfc on 2017/7/7.
 */
public class SecurityUtil {
    public static String getUid(){
        return getUser() == null ? "" : getUser().getUid();
    }

    public static SecurityUser getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return (SecurityUser) authentication.getPrincipal();
    }

    public static boolean isRoot() {
        return "root".equals(getUser().getUsername());
    }
}
