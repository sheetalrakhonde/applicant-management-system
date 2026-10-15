package com.des.applicantmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.des.applicantmanagement.entity.Applicant;

public interface ApplicantRepository
        extends JpaRepository<Applicant, Long> {

}