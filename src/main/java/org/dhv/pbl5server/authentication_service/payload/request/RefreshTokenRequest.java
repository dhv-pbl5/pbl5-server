package org.dhv.pbl5server.authentication_service.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dhv.pbl5server.common_service.annotation.JsonSnakeCaseNaming;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSnakeCaseNaming
public class RefreshTokenRequest {
    @NotBlank
    private String refreshToken;
}
