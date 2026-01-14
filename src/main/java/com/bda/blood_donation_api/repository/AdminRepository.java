package com.bda.blood_donation_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bda.blood_donation_api.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
