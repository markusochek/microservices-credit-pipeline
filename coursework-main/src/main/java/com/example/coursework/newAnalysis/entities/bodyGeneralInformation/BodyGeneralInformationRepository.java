package com.example.coursework.newAnalysis.entities.bodyGeneralInformation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyGeneralInformationRepository extends JpaRepository<BodyGeneralInformation, Integer> {
}
