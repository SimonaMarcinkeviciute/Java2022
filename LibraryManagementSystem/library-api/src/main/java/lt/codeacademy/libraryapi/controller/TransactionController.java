package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import lt.codeacademy.libraryapi.data.Status;
import lt.codeacademy.libraryapi.data.TransactionStatus;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Item;
import lt.codeacademy.libraryapi.dto.Transaction;
import lt.codeacademy.libraryapi.service.ItemService;
import lt.codeacademy.libraryapi.service.TransactionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.*;

@RestController
@RequestMapping(TRANSACTIONS)
@Api(tags = "Library transaction controller")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = TRANSACTION,produces = MediaType.APPLICATION_JSON_VALUE)
    public void transaction(@PathVariable(itemId) UUID id, Principal principal) {

        transactionService.createTransaction(id, principal);
    }


    @GetMapping(value = TRANSACTION_BY_USER,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> transaction(Principal principal) {

        return transactionService.getTransactionsByUser(principal);

    }

    @GetMapping(value = RETURN_TRANSACTION,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> returnTransaction(@PathVariable(transactionId) UUID id, Principal principal) {

        transactionService.updateTransaction(id);
        return transactionService.getTransactionsByUser(principal);

    }

    @GetMapping(value = ISAVAILABLE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean isAvailable(@PathVariable(bookId) UUID id, Principal principal) {

        return transactionService.isAvailableByUser(id, principal);
    }

}
