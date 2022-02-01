package com.projetoGustavo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException  {

    // app de excecao
    public ObjectNotFoundException(String msg){
        super(msg); // super vem do RunTimeException
    }

    public ObjectNotFoundException(String msg, Throwable cause){ // Throwable cause outra excessao que aconteceu antes
        super(msg, cause);
    }
}
