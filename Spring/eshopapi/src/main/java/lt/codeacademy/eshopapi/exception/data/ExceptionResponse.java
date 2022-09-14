package lt.codeacademy.eshopapi.exception.data;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
public class ExceptionResponse {
    //tai ka rodysim vartotojui
    private final String message;
    private final int status;
    private final long timestamp;

    public ExceptionResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value(); //pasiimsim statuso koda
        timestamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();
    }
}
