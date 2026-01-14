package com.bda.blood_donation_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bda.blood_donation_api.model.Donor;
import com.bda.blood_donation_api.repository.DonorRepository;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Donor addDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    public Donor updateDonor(Long id, Donor donor) {
        Donor existing = donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor not found with id: " + id));

        existing.setName(donor.getName());
        existing.setPhone(donor.getPhone());
        existing.setEmail(donor.getEmail());
        existing.setBloodGroup(donor.getBloodGroup());
        existing.setLocation(donor.getLocation());
        existing.setAge(donor.getAge());
        existing.setLastDonation(donor.getLastDonation());
        existing.setAvailability(donor.getAvailability());

        return donorRepository.save(existing);
    }

    public void deleteDonor(Long id) {
        if (!donorRepository.existsById(id)) {
            throw new RuntimeException("Donor not found with id: " + id);
        }
        donorRepository.deleteById(id);
    }
}
