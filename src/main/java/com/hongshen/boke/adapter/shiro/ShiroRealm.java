package com.hongshen.boke.adapter.shiro;

import com.hongshen.boke.controller.shiro.UsernamePasswordAndOtherToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/7/3 17:29
 * @Desc: AuthenticatingRealm
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)  throws AuthenticationException {
        System.out.println("我是校验认证11111");
        UsernamePasswordToken token =(UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        //获取realm名称
        String realmName = getName();
        //盐值  使用盐值传入的参数一样要保持唯一 比如使用账户名 username
        ByteSource source = ByteSource.Util.bytes(username);
        String md5= "MD5";
        Object credentials= token.getPassword();
        int num=1024;
        SimpleHash result = new SimpleHash(md5, credentials, source, num);
        //使用md5盐值加密 （为什么使用盐值加密 如果两个用户初始密码一样 只用md5加密后 密文也是一样的
        // 为了让初始密码一样 但加密后的密文不一样 所以使用盐值加密 ）
          SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, result,source, realmName);
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,credentials, realmName);
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("我是授权");

        return null;
    }


    public static void main(String[] args) {
        String md5= "MD5";
        Object credentials= "123456";
        Object source=ByteSource.Util.bytes("123");
        int num=1024;
        SimpleHash result = new SimpleHash(md5, credentials, source, num);
        //b2793335f43645fd8e00c7d18e14e05f
        System.out.println(result);
    }


}
