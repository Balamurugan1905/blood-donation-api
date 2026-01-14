package com.bda.blood_donation_api.service;

import org.springframework.stereotype.Service;

import com.bda.blood_donation_api.model.Admin;
import com.bda.blood_donation_api.repository.AdminRepository;


@Service
public class AdminService {

    private final AdminRepository repo;

    public AdminService(AdminRepository repo) {
        this.repo = repo;
    }

    public boolean login(String username, String password) {
        Admin admin = repo.findByUsername(username);
        if (admin == null) return false;
        return admin.getPassword().equals(password);
    }
}
