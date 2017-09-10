package tk.codedojo.exception;

public class DuplicateUserNameException extends Exception {
    public DuplicateUserNameException(String message){
        super(message);
    }
}
