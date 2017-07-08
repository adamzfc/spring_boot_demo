package com.adamzfc.config;

import com.adamzfc.security.MyUserDetailService;
import com.adamzfc.security.UrlSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by adamzfc on 4/7/17.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected MyUserDetailService userDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().disable();
//        http.headers().disable();
//        http.jee().disable();
//        http.x509().disable();
//        http.servletApi().disable();
//        http.anonymous().disable();
//        http.requestCache().disable();

        http.authorizeRequests()
                .anyRequest().authenticated()
                .antMatchers("/**").hasAuthority("ADMIN")
                .and()
                .formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).logoutSuccessUrl("/login");;

//        http.authorizeRequests()
//                .anyRequest().fullyAuthenticated()
//                .mvcMatchers("/login").permitAll();
//
//        http.rememberMe().userDetailsService(userDetailService).useSecureCookie(false).alwaysRemember(true);
//        http.addFilterAt(urlSecurityInterceptor(), FilterSecurityInterceptor.class);
//        http.formLogin().loginProcessingUrl("/login").loginPage("/to-login").permitAll().defaultSuccessUrl("/");
    }

//    public UrlSecurityInterceptor urlSecurityInterceptor() {
//        return new UrlSecurityInterceptor();
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**/*.js", "/**/*.js.map", "/**/*.ts", "/**/*.css", "/**/*.css.map", "/**/*.png", "/**/*.gif", "/**/*.jpg", "/**/*.fco", "/**/*.woff", "/**/*.woff2", "/**/*.font", "/**/*.svg", "/**/*.ttf", "/**/*.pdf","/*.ico", "/admin/api/**", "/404", "/401","/403", "/error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("ADMIN");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }
}
