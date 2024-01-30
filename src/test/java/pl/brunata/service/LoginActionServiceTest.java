package pl.brunata.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginActionServiceTest {

    @Test
    void loginAction() {
        LoginActionService loginActionService = new LoginActionService();
        loginActionService.loginAction();
    }
}