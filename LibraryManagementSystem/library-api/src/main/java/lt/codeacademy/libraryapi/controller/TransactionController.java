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
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.*;

@RestController
@RequestMapping(TRANSACTIONS)
@Api(tags = "Library transaction controller")
public class TransactionController {

    private final TransactionService transactionService;
    private final ItemService itemService;

    public TransactionController(TransactionService transactionService, ItemService itemService) {
        this.transactionService = transactionService;
        this.itemService = itemService;
    }

    @GetMapping(value = TRANSACTION,produces = MediaType.APPLICATION_JSON_VALUE)
    public void transaction(@PathVariable(itemId) UUID id) {
        Item item = itemService.getItemById(id);
        item.setStatus(Status.UNAVAILABLE);
        itemService.updateItemStatus(item);

        Transaction transaction = new Transaction(null, TransactionStatus.BORROWED, item, LocalDate.now() );
        transactionService.createTransaction(transaction);
    }


}
