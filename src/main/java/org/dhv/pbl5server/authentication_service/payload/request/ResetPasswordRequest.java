package org.dhv.pbl5server.authentication_service.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dhv.pbl5server.common_service.annotation.JsonSnakeCaseNaming;
import org.dhv.pbl5server.common_service.annotation.NotBlankStringValidation;
import org.dhv.pbl5server.common_service.annotation.PasswordValidation;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSnakeCaseNaming
public class ResetPasswordRequest {
    @NotBlankStringValidation
    private String resetPasswordToken;
    @PasswordValidation
    private String newPassword;
    @PasswordValidation
    private String newPasswordConfirmation;
}
