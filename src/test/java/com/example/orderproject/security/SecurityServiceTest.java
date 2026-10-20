package com.example.orderproject.security;

import com.example.orderproject.exceptions.UnauthorizedException;
import com.example.orderproject.users.User;
import com.example.orderproject.users.UserRepository;
import com.example.orderproject.users.UserService;
import com.example.orderproject.users.enums.Feature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SecurityServiceTest {

    @Mock
    private UserRepository userRepo;

    @Mock
    private UserService userService;

    @Mock
    private User user;

    @InjectMocks
    private SecurityService securityService;

    @Test
    void validateAuthorizationWithValidCredentialsAndFeatureDoesNotThrow() {
        when(userRepo.getUserByEmail("admin@example.com")).thenReturn(Optional.of(user));
        when(user.doesPasswordMatch("secret")).thenReturn(true);
        when(user.canHaveAccessTo(Feature.ADD_ITEM)).thenReturn(true);

        assertDoesNotThrow(() -> securityService.validateAuthorization(basicAuth("admin@example.com", "secret"), Feature.ADD_ITEM));
    }

    @Test
    void validateAuthorizationWithMissingAuthThrowsUnauthorized() {
        assertThrows(UnauthorizedException.class,
                () -> securityService.validateAuthorization(null, Feature.ADD_ITEM));
    }

    @Test
    void validateAuthorizationWithMalformedBase64ThrowsUnauthorized() {
        assertThrows(UnauthorizedException.class,
                () -> securityService.validateAuthorization("Basic !!!", Feature.ADD_ITEM));
    }

    @Test
    void validateAuthorizationWithUnknownUserThrowsUnauthorized() {
        when(userRepo.getUserByEmail("unknown@example.com")).thenReturn(Optional.empty());

        assertThrows(UnauthorizedException.class,
                () -> securityService.validateAuthorization(basicAuth("unknown@example.com", "secret"), Feature.ADD_ITEM));
    }

    @Test
    void validateAuthorizationWithWrongPasswordThrowsUnauthorized() {
        when(userRepo.getUserByEmail("admin@example.com")).thenReturn(Optional.of(user));
        when(user.doesPasswordMatch("wrong")).thenReturn(false);

        assertThrows(UnauthorizedException.class,
                () -> securityService.validateAuthorization(basicAuth("admin@example.com", "wrong"), Feature.ADD_ITEM));
    }

    @Test
    void validateAuthorizationWithoutRequiredFeatureThrowsUnauthorized() {
        when(userRepo.getUserByEmail("user@example.com")).thenReturn(Optional.of(user));
        when(user.doesPasswordMatch("secret")).thenReturn(true);
        when(user.canHaveAccessTo(Feature.ADD_ITEM)).thenReturn(false);

        assertThrows(UnauthorizedException.class,
                () -> securityService.validateAuthorization(basicAuth("user@example.com", "secret"), Feature.ADD_ITEM));
    }

    private String basicAuth(String email, String password) {
        String credentials = email + ":" + password;
        String encoded = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
        return "Basic " + encoded;
    }
}
