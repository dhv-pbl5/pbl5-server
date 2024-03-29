package org.dhv.pbl5server.authentication_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dhv.pbl5server.authentication_service.annotation.CurrentAccount;
import org.dhv.pbl5server.authentication_service.entity.Account;
import org.dhv.pbl5server.authentication_service.payload.request.*;
import org.dhv.pbl5server.authentication_service.service.AuthService;
import org.dhv.pbl5server.common_service.model.ApiDataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<ApiDataResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(authService.login(loginRequest, false)));
    }

    @PostMapping("/admin/auth/login")
    public ResponseEntity<ApiDataResponse> loginAdmin(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(authService.login(loginRequest, true)));
    }

    @PostMapping("/auth/refresh-token")
    public ResponseEntity<ApiDataResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(authService.refreshToken(refreshTokenRequest, false)));
    }

    @PostMapping("/admin/auth/refresh-token")
    public ResponseEntity<ApiDataResponse> refreshTokenAdmin(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(authService.refreshToken(refreshTokenRequest, true)));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'COMPANY')")
    @PostMapping("/auth/logout")
    public ResponseEntity<ApiDataResponse> logoutUser(@CurrentAccount Account currentAccount) {
        authService.logout(currentAccount);
        return ResponseEntity.ok(ApiDataResponse.successWithoutMetaAndData());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'COMPANY')")
    @GetMapping("/auth/account")
    public ResponseEntity<ApiDataResponse> getAccount(@CurrentAccount Account currentAccount) {
        return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(authService.getAccount(currentAccount)));
    }

    @PostMapping("/auth/register")
    public ResponseEntity<ApiDataResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(authService.register(request)));
    }

    @PreAuthorize("hasAnyAuthority('USER', 'COMPANY')")
    @PostMapping("/auth/forgot-password")
    public ResponseEntity<ApiDataResponse> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {
        String resetPasswordToken = authService.forgotPassword(request);
        Map<String, String> data = Map.of("reset_password_token", resetPasswordToken);
        return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(data));
    }

    @PreAuthorize("hasAnyAuthority('USER', 'COMPANY')")
    @PostMapping("/auth/reset-password")
    public ResponseEntity<ApiDataResponse> resetPassword(
        @Valid @RequestBody ResetPasswordRequest request,
        @CurrentAccount Account currentAccount
    ) {
        authService.resetPassword(request, currentAccount);
        return ResponseEntity.ok(ApiDataResponse.successWithoutMetaAndData());
    }

    @PreAuthorize("hasAnyAuthority('USER', 'COMPANY')")
    @PostMapping("/auth/change-password")
    public ResponseEntity<ApiDataResponse> changePassword(
        @Valid @RequestBody ChangePasswordRequest request,
        @CurrentAccount Account currentAccount
    ) {
        authService.changePassword(request, currentAccount);
        return ResponseEntity.ok(ApiDataResponse.successWithoutMetaAndData());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/auth/deactivate-account/{accountId}")
    public ResponseEntity<ApiDataResponse> deactivateAccount(@PathVariable("accountId") String accountId) {
        return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(authService.deactivateAccount(accountId)));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/auth/activate-account/{accountId}")
    public ResponseEntity<ApiDataResponse> activateAccount(@PathVariable("accountId") String accountId) {
        return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(authService.activateAccount(accountId)));
    }
}

