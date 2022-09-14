//package lt.codeacademy.eshopapi.advice;
//
//import lt.codeacademy.eshopapi.exception.ProductNotExistException;
//import lt.codeacademy.eshopapi.exception.data.ExceptionResponse;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MissingServletRequestParameterException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
////restControlleradvice nes mes grazinsime objekta, todel reikalingas kazkoks kontentas.
//@RestControllerAdvice
//public class ApplicationExceptionAdvice {
//
//    //api turi grazinti statusa, negrazins jokio page, ir neturi atsirasto tokie error kaip white labbel.
//    //turi grazinti statusa, kad yra blogas statusas
//
//
//    //anotacija, kad gausim tos klases exception
//    @ExceptionHandler(ProductNotExistException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)//kad narsykle gautu tinkama responce statusa, kad negautu 200 responce
//    //turim grazinti objekta, kuri susikureme
//    public ExceptionResponse handleProductNotExistException(ProductNotExistException exception) {
//        return new ExceptionResponse(String.format("Cannot found product %s", exception.getProductId()), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)//nes illegal sako, kad yra kzakas blogai
//    public ExceptionResponse handleIllegalArgumentException(IllegalArgumentException exception) {
//        return new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(EmptyResultDataAccessException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND) //404
//    public ExceptionResponse handleEmptyResultDataAccessException(EmptyResultDataAccessException exception) {
//        return new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ExceptionResponse HandleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
//        return new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    //globaliem exception
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ExceptionResponse handleException(Exception exception) {
//        return new ExceptionResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);//500
//    }
//}

package lt.codeacademy.eshopapi.advice;

import lt.codeacademy.eshopapi.exception.FileException;
import lt.codeacademy.eshopapi.exception.ProductNotExistException;
import lt.codeacademy.eshopapi.exception.data.ExceptionResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionAdvice {

    @ExceptionHandler(ProductNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleProductNotExistException(ProductNotExistException exception) {
        return new ExceptionResponse(String.format("Cannot found product %s", exception.getProductId()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleIllegalArgumentException(IllegalArgumentException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleEmptyResultDataAccessException(EmptyResultDataAccessException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleFileException(FileException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(Exception exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
