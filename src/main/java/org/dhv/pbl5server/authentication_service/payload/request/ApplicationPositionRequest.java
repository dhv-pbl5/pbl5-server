package org.dhv.pbl5server.authentication_service.payload.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dhv.pbl5server.common_service.annotation.JsonSnakeCaseNaming;
import org.dhv.pbl5server.constant_service.payload.ConstantSelectionRequest;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSnakeCaseNaming
public class ApplicationPositionRequest {
    private UUID id;
    @NotNull
    private Boolean status;
    @NotNull
    @Valid
    private ConstantSelectionRequest applyPosition;
    @NotNull
    @NotEmpty
    private List<ApplicationSkillRequest> skills;
}
