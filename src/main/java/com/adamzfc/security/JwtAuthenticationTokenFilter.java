package com.adamzfc.security;

import com.adamzfc.application.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by adamzfc on 2017/7/8.
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private ConfigService configService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }
}
