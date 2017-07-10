package com.adamzfc.application;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by adamzfc on 2017/7/8.
 */
@Data
@Service
public class ConfigService {
    @Value("${myconfig.jwt.header}")
    private String jwtTokenHeader;

    @Value("${myconfig.jwt.expiration}")
    private Long expiration;

    @Value("${myconfig.jwt.secret}")
    private String secret;

    @Value("${myconfig.jwt.tokenHead}")
    private String tokenHead;

}
