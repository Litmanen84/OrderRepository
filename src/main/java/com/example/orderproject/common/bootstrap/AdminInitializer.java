package com.example.orderproject.common.bootstrap;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name = "app.bootstrap.admin.enabled",
        havingValue = "true"
)
public class AdminInitializer implements ApplicationRunner {

    private final AdminBootstrapService adminBootstrapService;
    private final String email;
    private final String password;

    public AdminInitializer(
            AdminBootstrapService adminBootstrapService,
            @org.springframework.beans.factory.annotation.Value(
                    "${app.bootstrap.admin.email}") String email,
            @org.springframework.beans.factory.annotation.Value(
                    "${app.bootstrap.admin.password}") String password) {

        this.adminBootstrapService = adminBootstrapService;
        this.email = email;
        this.password = password;
    }

    @Override
    public void run(ApplicationArguments args) {
        adminBootstrapService.createAdminIfNotExists(email, password);
    }
}
