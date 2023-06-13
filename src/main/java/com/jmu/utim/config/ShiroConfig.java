package com.jmu.utim.config;

import com.jmu.utim.realm.MyRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean s = new ShiroFilterFactoryBean();
        s.setSecurityManager(defaultWebSecurityManager);
        // 设置登录url
        s.setLoginUrl("/toLogin");
        // 设置url 的 访问规则
        // authc 需要登录；anon—无需认证
        Map<String, String> filterChainMap = new LinkedHashMap<>();
//        filterChainMap.put("/roles/**", "roles[role_superman]");
//        filterChainMap.put("/users/**", "roles[role_superman]");
//        filterChainMap.put("/licenses/**", "authc");
//        filterChainMap.put("/devices/**", "authc");
        s.setFilterChainDefinitionMap(filterChainMap);
        return s;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    @Bean
    public Realm myRealm(CredentialsMatcher credentialsMatcher) {
        MyRealm myRealm = new MyRealm();
        // 告诉Realm密码的匹配方式
        myRealm.setCredentialsMatcher(credentialsMatcher);
        return myRealm;
    }

    @Bean
    public CredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher hashedMatcher = new HashedCredentialsMatcher();
        hashedMatcher.setHashAlgorithmName("md5");
        hashedMatcher.setHashIterations(3);
        return hashedMatcher;
    }

    /**
     * 注解支持：
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
    /**
     * 注解支持：
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }

//    @Autowired
//    private MyRealm myRealm;
//
//    @Bean
//    public DefaultWebSecurityManager defaultWebSecurityManager() {
//        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
//        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
//
//        matcher.setHashAlgorithmName("md5");
//        matcher.setHashIterations(3);
//
//        myRealm.setCredentialsMatcher(matcher);
//        defaultWebSecurityManager.setRealm(myRealm);
//
////        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
//        return defaultWebSecurityManager;
//    }



//    public SimpleCookie rememberMeCookie() {
//        SimpleCookie cookie = new SimpleCookie("rememberMe");
//
//        cookie.setPath("/");
//        cookie.setHttpOnly(true);
//        cookie.setMaxAge(30*24*60*60);
//
//        return cookie;
//    }
//
//    public CookieRememberMeManager rememberMeManager(){
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//
//        cookieRememberMeManager.setCookie(rememberMeCookie());
//
//        cookieRememberMeManager.setCipherKey("1234567890987654".getBytes());
//
//        return cookieRememberMeManager;
//    }

//    @Bean
//    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition() {
//        DefaultShiroFilterChainDefinition definition =  new DefaultShiroFilterChainDefinition();
//
//        definition.addPathDefinition("/users/fems","anon");//允许匿名访问
//        definition.addPathDefinition("/users/1","anon");//允许匿名访问
//        definition.addPathDefinition("/backend/page/login.html","anon");//允许匿名访问
//        definition.addPathDefinition("/**","user");
//
//        definition.addPathDefinition("/**","authc");//必须验证身份访问
//        return definition;
//    }
}