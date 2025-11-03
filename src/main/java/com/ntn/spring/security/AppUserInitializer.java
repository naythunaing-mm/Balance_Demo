package com.ntn.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ntn.spring.modal.domain.entity.User;
import com.ntn.spring.modal.domain.entity.User.Role;
import com.ntn.spring.modal.repo.UserRepo;

@Component
public class AppUserInitializer {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @EventListener(ContextRefreshedEvent.class)
    public void initializeAdminUser() {
        var existingAdmin = userRepo.findOneByLoginId("admin");

        if (existingAdmin.isEmpty()) {
            User admin = new User();
            admin.setName("Admin User");
            admin.setLoginId("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setRole(Role.ADMIN);
            admin.setActive(true);
            admin.setEmail("admin@gmail.com");
            admin.setPhone("09772803152");
            userRepo.save(admin);

            System.out.println("Default admin user created (loginId='admin', password='admin')");
        } else {
            System.out.println("Admin user already exists — skipping creation.");
        }
    }
}
