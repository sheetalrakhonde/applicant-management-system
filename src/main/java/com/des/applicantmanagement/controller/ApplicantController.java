package com.des.applicantmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.des.applicantmanagement.entity.Applicant;
import com.des.applicantmanagement.service.ApplicantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    // Create an applicant
    @PostMapping
    public ResponseEntity<Applicant> createApplicant(@Valid @RequestBody Applicant applicant) {

    	System.out.println("First Name: " + applicant.getFirstName());
    	System.out.println("Last Name: " + applicant.getLastName());
    	System.out.println("Email: " + applicant.getEmail());
    	System.out.println("Phone: " + applicant.getPhone());
    	System.out.println("Birth Date: " + applicant.getBirthDate());
        Applicant savedApplicant = applicantService.createApplicant(applicant);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedApplicant);
    }

    // Get all applicants
    @GetMapping
    public ResponseEntity<List<Applicant>> getAllApplicants() {

        return ResponseEntity.ok(
                applicantService.getAllApplicants()
        );
    }

    // Get an applicant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getApplicantById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                applicantService.getApplicantById(id)
        );
    }

    // Update an applicant
    @PutMapping("/{id}")
    public ResponseEntity<Applicant> updateApplicant(
            @PathVariable Long id,
            @Valid @RequestBody Applicant applicant) {

        Applicant updatedApplicant =
                applicantService.updateApplicant(id, applicant);

        return ResponseEntity.ok(updatedApplicant);
    }

    // Delete an applicant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicant(
            @PathVariable Long id) {

        applicantService.deleteApplicant(id);

        return ResponseEntity.noContent().build();
    }
}