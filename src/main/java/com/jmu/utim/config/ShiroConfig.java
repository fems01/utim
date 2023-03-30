package com.jmu.utim.config;

import com.jmu.utim.shiro.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ShiroConfig {

    @Autowired
    private MyRealm myRealm;

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();

        matcher.setHashAlgorithmName("md5");

        matcher.setHashIterations(3);

        myRealm.setCredentialsMatcher(matcher);

        defaultWebSecurityManager.setRealm(myRealm);

        return defaultWebSecurityManager;
    }

    @Bean
    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("","anon:免认证");

        definition.addPathDefinition("","authc:认证");

        return definition;
    }
}
