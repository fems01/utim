package com.jmu.utim.config;

import com.jmu.utim.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    @Autowired
    private MyRealm myRealm;

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();

        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(3);

        myRealm.setCredentialsMatcher(matcher);
        defaultWebSecurityManager.setRealm(myRealm);

        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
        return defaultWebSecurityManager;
    }



    public SimpleCookie rememberMeCookie() {
        SimpleCookie cookie = new SimpleCookie("rememberMe");

        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(30*24*60*60);

        return cookie;
    }

    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();

        cookieRememberMeManager.setCookie(rememberMeCookie());

        cookieRememberMeManager.setCipherKey("1234567890987654".getBytes());

        return cookieRememberMeManager;
    }

    @Bean
    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition =  new DefaultShiroFilterChainDefinition();

        definition.addPathDefinition("/users/fems","anon");//允许匿名访问
        definition.addPathDefinition("/users/1","anon");//允许匿名访问
        definition.addPathDefinition("/backend/page/login.html","anon");//允许匿名访问
        definition.addPathDefinition("/**","user");

        definition.addPathDefinition("/**","authc");//必须验证身份访问
        return definition;
    }
}
