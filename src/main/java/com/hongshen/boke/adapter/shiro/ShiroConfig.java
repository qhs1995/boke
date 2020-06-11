//package com.hongshen.boke.adapter.shiro;
//
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
//import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
//import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
//import org.apache.shiro.authz.Authorizer;
//import org.apache.shiro.authz.ModularRealmAuthorizer;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.realm.Realm;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.LinkedHashMap;
//
///**
// * Created with IDEA
// *
// * @author:qianhongshen
// * @Date:2019/7/3 17:44
// * @Desc:
// */
//@Configuration
//public class ShiroConfig {
//    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
//
//    /**
//     * 密码校验规则HashedCredentialsMatcher
//     * 这个类是为了对密码进行编码的 ,
//     * 防止密码在数据库里明码保存 , 当然在登陆认证的时候 ,
//     * 这个类也负责对form里输入的密码进行编码
//     * 处理认证匹配处理器：如果自定义需要实现继承HashedCredentialsMatcher
//     */
//    @Bean("hashedCredentialsMatcher")
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
//        //指定加密方式为MD5
//        credentialsMatcher.setHashAlgorithmName("MD5");
//        //加密次数
//        credentialsMatcher.setHashIterations(1024);
//        credentialsMatcher.setStoredCredentialsHexEncoded(true);
//        return credentialsMatcher;
//    }
//
//
//    @Bean("authRealm")
//   // @DependsOn("lifecycleBeanPostProcessor")//可选
//    public ShiroRealm authRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher) {
//        ShiroRealm authRealm = new ShiroRealm();
//        authRealm.setCredentialsMatcher(matcher);
//        return authRealm;
//    }
//
//
////    @Bean("hashedCredentialsMatcher2")
////    public HashedCredentialsMatcher hashedCredentialsMatcher2() {
////        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
////        //指定加密方式为SHA1
////        credentialsMatcher.setHashAlgorithmName("SHA1");
////        //加密次数
////        credentialsMatcher.setHashIterations(1024);
////        credentialsMatcher.setStoredCredentialsHexEncoded(true);
////        return credentialsMatcher;
////    }
////
////
////    @Bean("authRealm2")
////    public ShiroRealm2 authRealm2(@Qualifier("hashedCredentialsMatcher2") HashedCredentialsMatcher matcher) {
////        ShiroRealm2 authRealm = new ShiroRealm2();
////        authRealm.setCredentialsMatcher(matcher);
////        return authRealm;
////    }
//
//
//    //    @Bean("authRealm")
//    //    public ShiroRealm authRealm() {
//    //        ShiroRealm authRealm = new ShiroRealm();
//    //        return authRealm;
//    //    }
//
//
//    /**
//     * 多realm认证器
//     * @param authRealm
//     * @param authRealm2
//     * @return
//     */
////    @Bean("authenticator")
////    public ModularRealmAuthenticator realmAuthenticator(@Qualifier("authRealm") ShiroRealm authRealm,
////                                                        @Qualifier("authRealm2") ShiroRealm2 authRealm2){
////        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
////
////        //配置认证策略
////        //   FirstSuccessfulStrategy：只要有一个 Realm 验证成功即可，只返回第 一个 Realm 身份验证成功的认证信息，其他的忽略；
////        // • AtLeastOneSuccessfulStrategy：只要有一个Realm验证成功即可，和 FirstSuccessfulStrategy 不同，将返回所有Realm身份验证成功的认证信息；
////        // • AllSuccessfulStrategy：所有Realm验证成功才算成功，且返回所有 Realm身份验证成功的认证信息，如果有一个失败就失败了。
////        // • ModularRealmAuthenticator 默认是 AtLeastOneSuccessfulStrategy 策略
////        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
////        Collection<Realm> list = new ArrayList<>();
////        list.add(authRealm);
////        list.add(authRealm2);
////        authenticator.setRealms(list);
////        return authenticator;
////    }
//
//
//    /**
//     * 定义安全管理器securityManager,注入自定义的realm
//     * @param authRealm
//     * @return
//     */
//    @Bean("securityManager")
//    public SecurityManager securityManager(@Qualifier("authRealm") ShiroRealm authRealm
////                                           ,@Qualifier("authRealm2") ShiroRealm2 authRealm2,
////                                           @Qualifier("authenticator") ModularRealmAuthenticator authenticator
//                                          ) {
//        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//        manager.setRealm(authRealm);
////        Collection<Realm> list = new ArrayList<>();
////        list.add(authRealm);
////        list.add(authRealm2);
////        manager.setRealms(list);
////        manager.setAuthenticator(authenticator);
//        return manager;
//    }
//
//
//    /**
//     * 定义shiroFilter过滤器并注入securityManager
//     * @param manager
//     * @return
//     */
//    @Bean("shiroFilter")
//    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
//        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
//        //设置securityManager
//        bean.setSecurityManager(manager);
//        //设置登录页面
//        //可以写路由也可以写jsp页面的访问路径
//        bean.setLoginUrl("/toutist/login.html");
//        //设置登录成功跳转的页面
//        bean.setSuccessUrl("/before/index");
//        //设置未授权跳转的页面
//        bean.setUnauthorizedUrl("/toutist/login.html");
//        //定义过滤器
//        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        filterChainDefinitionMap.put("/shiro/login", "anon");
//        filterChainDefinitionMap.put("/shiro/a", "roles[user]");
//        filterChainDefinitionMap.put("/guest/getMessage", "roles[user]");
//        filterChainDefinitionMap.put("/edit", "perms[delete]");
//        //需要登录访问的资源 , 一般将/**放在最下边
//        filterChainDefinitionMap.put("/shiro/logins", "authc");
//        filterChainDefinitionMap.put("/*/*", "authc");
//        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return bean;
//    }
//
//    /**
//     * Spring的一个bean , 由Advisor决定对哪些类的方法进行AOP代理 .
//     * @return
//     */
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
//        creator.setProxyTargetClass(true);
//        return creator;
//    }
//
//    /**
//     * 配置shiro跟spring的关联
//     * @param securityManager
//     * @return
//     */
////    @Bean
////    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
////        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
////        advisor.setSecurityManager(securityManager);
////        return advisor;
////    }
//
//    /**
//     * lifecycleBeanPostProcessor是负责生命周期的 , 初始化和销毁的类
//     * (可选)
//     */
////    @Bean("lifecycleBeanPostProcessor")
////    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
////        return new LifecycleBeanPostProcessor();
////    }
//}
