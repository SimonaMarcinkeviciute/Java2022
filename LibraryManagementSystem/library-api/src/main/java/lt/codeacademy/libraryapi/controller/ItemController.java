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
import java.security.Principal;
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
    public List<Item> getAvailableItemsByBook(@PathVariable(bookId) UUID id, Principal principal)  {


        List<Item> itemList = itemService.getAvailableItemsByBook(id, principal);
        return itemList;
    }

    @GetMapping(value = (ITEMS_BY_BOOK), produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItemsByBook(@PathVariable(bookId) UUID id)  {


        List<Item> itemList = itemService.getItemsByBook(id);
        return itemList;
    }

    @GetMapping(value = (CHANGE_ITEM_STATUS), produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> changeStatus(@PathVariable(itemId) UUID id, @PathVariable(bookId) UUID book)  {
        itemService.changeItemStatus(id);
         return itemService.getItemsByBook(book);


    }

}
