package lt.codeacademy.libraryapi.exception;

public class FileException extends RuntimeException {

    //runtimeException - kodas kuris mes ta klaida, jis neprivalo sucatchint
    //exception - turi sukachinti, arba padeklaruoti, kad matytu
    public FileException(String message) {
        super(message);
    }
}
