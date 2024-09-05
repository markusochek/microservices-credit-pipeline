package com.example.coursework.newAnalysis.entities.footLoanConditions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootLoanConditionsRepository extends JpaRepository<FootLoanConditions, Integer> {
}
