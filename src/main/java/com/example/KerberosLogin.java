package com.example;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class KerberosLogin {
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.auth.login.config", "src/main/resources/jaas.conf");
            System.setProperty("java.security.krb5.conf", "src/main/resources/krb5.conf");
            System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");

            LoginContext lc = new LoginContext("Client");
            lc.login();
            System.out.println("Kerberos Authentication Successful!");

        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
