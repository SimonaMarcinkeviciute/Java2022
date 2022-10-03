package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.data.Status;
import lt.codeacademy.libraryapi.data.TransactionStatus;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Item;
import lt.codeacademy.libraryapi.dto.Transaction;
import lt.codeacademy.libraryapi.dto.User;
import lt.codeacademy.libraryapi.entity.TransactionEntity;
import lt.codeacademy.libraryapi.entity.UserEntity;
import lt.codeacademy.libraryapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ItemService itemService;
    private final UserService userService;
    private final BookService bookService;

    public TransactionService(TransactionRepository transactionRepository, ItemService itemService, UserService userService, BookService bookService) {
        this.transactionRepository = transactionRepository;
        this.itemService = itemService;
        this.userService = userService;
        this.bookService = bookService;
    }

    public void createTransaction(UUID itemId, Principal principal) {

        Item item = itemService.getItemById(itemId);
        item.setStatus(Status.UNAVAILABLE);
        itemService.updateItemStatus(item);
        User user = (User) userService.loadUserByUsername(principal.getName());


        Transaction transaction = new Transaction(null, TransactionStatus.BORROWED,item, LocalDate.now(), user );

        transactionRepository.save(TransactionEntity.convert(transaction));


    }

    public List<Transaction> getTransactionsByUser(Principal principal) {

        User user = (User) userService.loadUserByUsername(principal.getName());

        List<Transaction> t = transactionRepository.findByUserEntity(UserEntity.convert(user)).stream()
                .map(Transaction::convert)
                .toList();

        return t;
    }

    public void updateTransaction(UUID transactionId) {

        Transaction transaction = transactionRepository.findById(transactionId).map(Transaction::convert).orElseThrow();
        Item item = itemService.getItemById(transaction.getItem().getId());
        item.setStatus(Status.AVAILABLE);
        itemService.updateItemStatus(item);
        transaction.setTransactionStatus(TransactionStatus.RETURNED);
        transaction.setLocalDate(LocalDate.now());
        transactionRepository.save(TransactionEntity.convert(transaction));
    }

    public boolean isAvailableByUser(UUID bookId, Principal principal) {

        Book book = bookService.findById(bookId);

        List<Transaction> t =  getTransactionsByUser(principal);

        if(t.size() < 1) {
            return true;
        }else {
            for(Transaction tr : t) {

                String title= tr.getItem().getBook().getTitle();
                if (tr.getItem().getBook().getTitle().equals(book.getTitle())) {
                    if(tr.getTransactionStatus().equals(TransactionStatus.BORROWED))
                    return false;
                }
            }
        }

        return true;
    }

}
