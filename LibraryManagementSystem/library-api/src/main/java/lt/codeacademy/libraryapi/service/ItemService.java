package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.data.Status;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Item;
import lt.codeacademy.libraryapi.entity.ItemEntity;
import lt.codeacademy.libraryapi.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(Book book, int itemQuantity) {
        Item item = new Item(Status.AVAILABLE, book, LocalDateTime.now());

        for (int i = 0; i<itemQuantity; i++) {
            ItemEntity itemEntity =itemRepository.save(ItemEntity.convert(item));
        }
    }
}
