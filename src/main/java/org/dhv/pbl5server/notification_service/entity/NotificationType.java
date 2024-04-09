package org.dhv.pbl5server.notification_service.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dhv.pbl5server.common_service.enums.AbstractEnum;
import org.dhv.pbl5server.constant_service.enums.ConstantTypePrefix;

@Getter
@AllArgsConstructor
public enum NotificationType implements AbstractEnum<NotificationType> {
    TEST("001", "Test"),
    // Match
    MATCHING("002", "Matching"),
    REJECT_MATCHING("003", "Reject Matching"),
    // Chat
    NEW_CONVERSATION("004", "New Conversation"),
    NEW_MESSAGE("005", "New Message"),
    READ_MESSAGE("006", "Read Message"),
    // Account
    ADMIN_DEACTIVATE_ACCOUNT("007", "Admin Deactivate Account"),
    ADMIN_ACTIVATE_ACCOUNT("008", "Admin Activate Account"),
    ;

    private final String value;
    private final String notificationName;
    private final String enumName = this.name();

    public String constantType() {
        return "%s%s".formatted(ConstantTypePrefix.NOTIFICATION_TYPE.getValue(), value);
    }
}