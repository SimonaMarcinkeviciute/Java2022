package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.data.Status;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Item;
import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.entity.ItemEntity;
import lt.codeacademy.libraryapi.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    public final BookService bookService;


    public ItemService(ItemRepository itemRepository, BookService bookService) {
        this.itemRepository = itemRepository;
        this.bookService = bookService;

    }

    public void createItem(Book book, int itemQuantity) {
        Item item = new Item(null, Status.AVAILABLE, book, LocalDateTime.now());

        for (int i = 0; i < itemQuantity; i++) {
            ItemEntity itemEntity = itemRepository.save(ItemEntity.convert(item));
        }
    }

    public List<Item> getAvailableItemsByBook(UUID id, Principal principal) {

        Book book = bookService.getBook(id);

        return itemRepository.findByStatusAndBookEntity(Status.AVAILABLE, BookEntity.convert(book))
                .stream()
                .map(Item::convert
                ).toList();
    }

    public Item getItemById(UUID id) {
        return itemRepository.findById(id).map(Item::convert).orElseThrow();
    }

    public void updateItemStatus(Item item) {
        itemRepository.save(ItemEntity.convert(item));
    }

    public List<Item> getItemsByBook(UUID id) {
        Book book = bookService.getBook(id);

        return itemRepository.findByBookEntity(BookEntity.convert(book))
                .stream()
                .map(Item::convert
                ).toList();
    }

    public void changeItemStatus(UUID id) {
        Item item = getItemById(id);
        item.setStatus(Status.WRITTEN_OF);

        updateItemStatus(item);
    }
}

