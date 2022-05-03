package edu.uaslp.objetos.shoppingcart;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException() {
        super("Null or empty string not allowed for item code");
    }
}
