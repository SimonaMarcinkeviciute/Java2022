package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.dto.Transaction;
import lt.codeacademy.libraryapi.entity.TransactionEntity;
import lt.codeacademy.libraryapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(Transaction transaction) {
        transactionRepository.save(TransactionEntity.convert(transaction));

    }
}
