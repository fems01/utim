package com.jmu.utim.realm;

import com.jmu.utim.entity.User;
import com.jmu.utim.service.LicenseService;
import com.jmu.utim.service.RoleService;
import com.jmu.utim.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private RoleService roleService;
    @Autowired
    private LicenseService licenseService;
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        String role = roleService.getRolesByName(user.getUsername());
        if(role != null) {
            simpleAuthorizationInfo.addRole(role);
        }
        Set<String> permissions = licenseService.getPermissionsByName(user.getUsername());
        if(permissions != null) {
            simpleAuthorizationInfo.addStringPermissions(permissions);
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        System.out.println(username+"------------------------------------------------------------");
        // 获取数据库的用户
        User user = userService.getUserInfoByName(username);

        if(user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes("salt"), // ? 盐就是 salt 常量
                authenticationToken.getPrincipal().toString()
        );
    }
}
