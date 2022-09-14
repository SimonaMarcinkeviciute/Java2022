package lt.codeacademy.libraryapi.advice;

import lt.codeacademy.libraryapi.exception.BookNotExistException;
import lt.codeacademy.libraryapi.exception.data.ExceptionResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//restController, nes grazinsim objekta kazkoki
@RestControllerAdvice
public class ApplicationExceptionAdvice {

    //grazinsim statusa, ne page

    //nurodom koki exception handlinsim
    @ExceptionHandler(BookNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //tam, kad narsykle suprastu, kad blogas statusas, kad negrazintu 200
    //grazinam objekta responce status, kuri susikureme
    public ExceptionResponse handleProductNotExistException(BookNotExistException exception) {
        return new ExceptionResponse(String.format("Cannot found product %s", exception.getBookId()), HttpStatus.NOT_FOUND);
        //404
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) //400
    public ExceptionResponse handleIllegalArgumentException(IllegalArgumentException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)//500
    @ResponseStatus(HttpStatus.NOT_FOUND)// siunciam 404
    public ExceptionResponse handleEmptyResultDataAccessException(EmptyResultDataAccessException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    //query neteisinga gaudo 400
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //handlinam visus exception, jei nebutu specifinio handlerio
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//500
    public ExceptionResponse handleException(Exception exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
