package com.example.coursework.newAnalysis.entities.bodyLoanConditions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyLoanConditionsRepository extends JpaRepository<BodyLoanConditions, Integer> {
}
