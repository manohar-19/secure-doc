/*
 * @author Manu
 * @version 1.0
 * @email manohar.r19@outlook.com
 * @portfolio https://portfolio-manu19.web.app/
 */

package com.manu.securedoc.utils;

import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
    public String getEmailMessage(String name, String host, String key) {
        return "Hello " + name + ",\n\nYour new account has been created. Please click on this link below to verify your account.\n\n" +
                getVerificationUrl(host, key) + "\n\n The Support Team";
 
    }

    private String getVerificationUrl(String host, String key) {
        return host + "/verify/account?key=" + key;
    }

    public String getResetPasswordMessage(String name, String host, String token) {
        return "Hello " + name + ",\n\nTo Reset the password. Please click on this link below to verify your account.\n\n" +
                getResetPasswordUrl(host, token) + "\n\n The Support Team";
    }

    private String getResetPasswordUrl(String host, String token) {
        return host + "/verify/password?token=" + token;
    }
}
