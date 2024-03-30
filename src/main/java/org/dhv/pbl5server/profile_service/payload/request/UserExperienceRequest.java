package org.dhv.pbl5server.profile_service.payload.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dhv.pbl5server.constant_service.entity.Constant;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserExperienceRequest {
    private UUID id;
    @NotNull
    private Timestamp experienceStartTime;
    @NotNull
    private Timestamp experienceEndTime;
    @NotNull
    private Constant experienceType;
    @NotNull
    @NotBlank
    private String workPlace;
    @NotNull
    @NotBlank
    private String position;
    private String note;
}