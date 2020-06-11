package com.hongshen.boke.controller.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/7/5 11:07
 * @Desc:
 */
public class UsernamePasswordAndOtherToken extends UsernamePasswordToken {

    private String VerificationCode;

    public UsernamePasswordAndOtherToken(String username, String password, String verificationCode) {
        super(username, password);
        VerificationCode = verificationCode;
    }

    public String getVerificationCode() {
        return VerificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        VerificationCode = verificationCode;
    }
}
