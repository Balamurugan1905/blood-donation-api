package com.bda.blood_donation_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bda.blood_donation_api.model.Donor;
import com.bda.blood_donation_api.service.DonorService;

@RestController
@RequestMapping("/donors")
@CrossOrigin("*")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @GetMapping
    public List<Donor> getAllDonors() {
        return donorService.getAllDonors();
    }

    @PostMapping
    public Donor addDonor(@RequestBody Donor donor) {
        return donorService.addDonor(donor);
    }

    @PutMapping("/{id}")
    public Donor updateDonor(@PathVariable Long id, @RequestBody Donor donor) {
        return donorService.updateDonor(id, donor);
    }

    @DeleteMapping("/{id}")
    public String deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return "Donor deleted successfully with id: " + id;
    }
}
