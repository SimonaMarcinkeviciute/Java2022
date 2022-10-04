package lt.codeacademy.libraryapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacademy.libraryapi.dto.Item;
import lt.codeacademy.libraryapi.service.ItemService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import static lt.codeacademy.libraryapi.ApplicationPath.*;

@RestController
@RequestMapping(ITEMS)
@Api(tags = "Library item controller")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ApiOperation(value = "Get available items by book", tags = "getItem", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Items returned successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = (AVAILABLE_ITEMS), produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAvailableItemsByBook(@PathVariable(bookId) UUID id, Principal principal) {

        return itemService.getAvailableItemsByBook(id, principal);
    }

    @ApiOperation(value = "Get items by book", tags = "getItem", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Items returned successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = (ITEMS_BY_BOOK), produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItemsByBook(@PathVariable(bookId) UUID id) {

        return itemService.getItemsByBook(id);
    }

    @ApiOperation(value = "Change item status", tags = "changeItem", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Items returned successfully"),
            @ApiResponse(code = 401, message = "User not authorized"),
            @ApiResponse(code = 404, message = "Request not found")
    })
    @GetMapping(value = (CHANGE_ITEM_STATUS), produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> changeStatus(@PathVariable(itemId) UUID id, @PathVariable(bookId) UUID book) {
        itemService.changeItemStatus(id);

        return itemService.getItemsByBook(book);
    }
}
