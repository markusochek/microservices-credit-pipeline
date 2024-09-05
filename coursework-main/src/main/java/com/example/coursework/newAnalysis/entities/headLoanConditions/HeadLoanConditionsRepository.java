package com.example.coursework.newAnalysis.entities.headLoanConditions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadLoanConditionsRepository extends JpaRepository<HeadLoanConditions, Integer> {
}
