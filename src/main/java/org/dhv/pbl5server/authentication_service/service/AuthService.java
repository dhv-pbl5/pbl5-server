package org.dhv.pbl5server.authentication_service.service;

import org.dhv.pbl5server.authentication_service.entity.Account;
import org.dhv.pbl5server.authentication_service.payload.request.*;
import org.dhv.pbl5server.authentication_service.payload.response.AccountResponse;
import org.dhv.pbl5server.authentication_service.payload.response.CredentialResponse;

// git commit -m "PBL-511 login for company and user"
// git commit -m "PBL-513 register for company"
// git commit -m "PBL-514 register for user"
// git commit -m "PBL-518 forgot password for company"
// git commit -m "PBL-519 forgot password for user"
// git commit -m "PBL-515 refresh token for admin"

public interface AuthService {
    CredentialResponse login(LoginRequest loginRequest, boolean isAdmin);

    CredentialResponse refreshToken(RefreshTokenRequest refreshTokenRequest, boolean isAdmin);

    AccountResponse getAccount(Account currentAccount);

    AccountResponse getAccountById(String id);

    void logout(Account currentAccount);

    AccountResponse register(UserRegisterRequest request);

    AccountResponse register(CompanyRegisterRequest request);

    void forgotPassword(ForgotPasswordRequest request);

    void resetPassword(ResetPasswordRequest request);

    void changePassword(ChangePasswordRequest request, Account currentAccount);
}
