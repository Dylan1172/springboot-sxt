package org.jit.sose.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        // 定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()   // 开放所有授权
                .antMatchers("/hello").hasRole("ROLE")      // ROLE角色拥有hello权限
                .antMatchers("/hello2").hasRole("ROLE2");   // ROLE2角色拥有hello2权限

        // 开启自动配置的登录功能

    }
}
