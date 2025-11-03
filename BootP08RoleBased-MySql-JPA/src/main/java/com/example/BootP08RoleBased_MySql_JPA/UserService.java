package com.example.BootP08RoleBased_MySql_JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUsers(List<UserRequest> userRequests) {
        for (UserRequest req : userRequests) {
            AppUser user=new AppUser();
            user.setUsername(req.getUsername());
            user.setPassword(passwordEncoder.encode(req.getPassword()));

            Set<Role> setRoles = new HashSet<>();
            for(String roleName : req.getRoles()) {
                Role role = roleRepo.findByName(roleName).orElseGet(()->{
                    Role newRole = new Role();
                    newRole.setName(roleName);
                    return roleRepo.save(newRole);
                });
                setRoles.add(role);
            }

            user.setRoles(setRoles);
            userRepo.save(user);

        }
    }

}
