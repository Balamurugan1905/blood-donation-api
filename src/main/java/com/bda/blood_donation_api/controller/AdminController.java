package com.bda.blood_donation_api.controller;

import org.springframework.web.bind.annotation.*;

import com.bda.blood_donation_api.service.AdminService;

@CrossOrigin(origins = {
  "http://localhost:3000",
  "https://saveone.vercel.app"
})
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody AdminLoginRequest req) {
        return service.login(req.getUsername(), req.getPassword());
    }

    // Inner class to avoid separate DTO file
    static class AdminLoginRequest {
        private String username;
        private String password;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
