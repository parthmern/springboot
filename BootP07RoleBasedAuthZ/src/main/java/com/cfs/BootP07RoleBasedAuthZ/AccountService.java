package com.cfs.BootP07RoleBasedAuthZ;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @PreAuthorize("isAuthenticated")
    // @PreAuthorize("hasRole('USER')")
    public String getBalance(){
        return "Balance is 1000";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String closeAccount(){
        return "Account closed";
    }

}
