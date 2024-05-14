package org.dhv.pbl5server.admin_service.service;

import java.util.List;

// git commit -m "PBL-510 login for admin"
// git commit -m "PBL-605 realtime deactivate account for user"
// git commit -m "PBL-606 realtime deactivate account for company"

public interface AdminService {

    void activateAccount(List<String> accountIds);

    void deactivateAccount(List<String> accountIds);

    void initialDefaultAccount();
}
