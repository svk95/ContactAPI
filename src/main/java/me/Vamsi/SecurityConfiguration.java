package me.Vamsi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;


@Configuration
@Component
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("datasource")
    private DataSource dataSource;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select userName,password as password FROM userdata where username=?");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()                      // it indicate basic authentication is requires
                .and()
                .authorizeRequests()
                .antMatchers( "/index").permitAll() // /index will be accessible directly, no need of any authentication
                .anyRequest().authenticated();    // it's indicate all request will be secure
        http.csrf().disable();
    }
}