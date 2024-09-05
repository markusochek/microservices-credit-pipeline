package com.example.coursework.client.entities.borrowerIncome;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerIncomeRepository extends JpaRepository<BorrowersIncome, Integer> {
}
