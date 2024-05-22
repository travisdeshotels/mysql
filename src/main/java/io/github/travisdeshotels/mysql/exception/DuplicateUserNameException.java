package io.github.travisdeshotels.mysql.exception;

public class DuplicateUserNameException extends Exception {
    public DuplicateUserNameException(String message){
        super(message);
    }
}
