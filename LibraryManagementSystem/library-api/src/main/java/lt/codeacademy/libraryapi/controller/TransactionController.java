package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacademy.libraryapi.dto.Transaction;
import lt.codeacademy.libraryapi.service.TransactionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @ApiOperation(value = "Create transaction", tags = "createTransaction", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transaction created successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = TRANSACTION,produces = MediaType.APPLICATION_JSON_VALUE)
    public void transaction(@PathVariable(itemId) UUID id, Principal principal) {

        transactionService.createTransaction(id, principal);
    }

    @ApiOperation(value = "Get transaction by user", tags = "getTransactionByUser", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transaction returned successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = TRANSACTION_BY_USER,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> transaction(Principal principal) {

        return transactionService.getTransactionsByUser(principal);
    }

    @ApiOperation(value = "Return transaction", tags = "returnTransaction", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transaction returned successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = RETURN_TRANSACTION,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> returnTransaction(@PathVariable(transactionId) UUID id, Principal principal) {
        transactionService.updateTransaction(id);

        return transactionService.getTransactionsByUser(principal);
    }

    @ApiOperation(value = "Is status available", tags = "availableStatus", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Status returned successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = ISAVAILABLE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean isAvailable(@PathVariable(bookId) UUID id, Principal principal) {

        return transactionService.isAvailableByUser(id, principal);
    }

}
