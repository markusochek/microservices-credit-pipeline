package com.example.coursework.client;

import com.example.coursework.client.entities.borrower.Borrower;
import com.example.coursework.client.entities.borrower.BorrowerRepository;
import com.example.coursework.client.entities.borrowerIncome.BorrowerIncomeRepository;
import com.example.coursework.client.entities.borrowerIncome.BorrowersIncome;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    private final BorrowerRepository borrowerRepository;
    private final BorrowerIncomeRepository borrowerIncomeRepository;

    public Boolean addClient(Borrower borrower, Borrower coBorrower, BorrowersIncome borrowersIncome) {
        borrowerRepository.save(borrower);
        borrowerRepository.save(coBorrower);
        borrowerIncomeRepository.save(borrowersIncome);
        return true;
    }
}
