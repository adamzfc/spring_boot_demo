package com.adamzfc.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by adamzfc on 2017/7/8.
 */
@Service
public class ConfigService {
    @Value("${myconfig.jwt.header}")
    private String jwtTokenHeader;

    public String getJwtTokenHeader() {
        return jwtTokenHeader;
    }

    public void setJwtTokenHeader(String jwtTokenHeader) {
        this.jwtTokenHeader = jwtTokenHeader;
    }
}
