package com.des.applicantmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.des.applicantmanagement.entity.Applicant;
import com.des.applicantmanagement.repository.ApplicantRepository;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    // Create an applicant
    public Applicant createApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    // Get all applicants
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    // Get an applicant by ID
    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Applicant not found with ID: " + id));
    }

    // Update an applicant
    public Applicant updateApplicant(Long id, Applicant updatedApplicant) {

        Applicant existingApplicant = getApplicantById(id);

        existingApplicant.setFirstName(updatedApplicant.getFirstName());
        existingApplicant.setLastName(updatedApplicant.getLastName());
        existingApplicant.setEmail(updatedApplicant.getEmail());
        existingApplicant.setPhone(updatedApplicant.getPhone());
        existingApplicant.setBirthDate(updatedApplicant.getBirthDate());

        return applicantRepository.save(existingApplicant);
    }

    // Delete an applicant
    public void deleteApplicant(Long id) {

        Applicant applicant = getApplicantById(id);

        applicantRepository.delete(applicant);
    }
}