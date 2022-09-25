package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Item;
import lt.codeacademy.libraryapi.service.BookService;
import lt.codeacademy.libraryapi.service.ItemService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.*;

//api/items
@RestController
@RequestMapping(ITEMS)
@Api(tags = "Library item controller")
public class ItemController {

    private final ItemService itemService;
    private final BookService bookService;

    public ItemController(ItemService itemService, BookService bookService) {
        this.itemService = itemService;
        this.bookService = bookService;
    }

    @GetMapping(value = (AVAILABLE_ITEMS), produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAvailableItems(@PathVariable(bookId) UUID id)  {
        Book book = bookService.getBook(id);
        List<Item> itemList = itemService.getAvailableItemsByBook(book);
        return itemList;
    }

}
