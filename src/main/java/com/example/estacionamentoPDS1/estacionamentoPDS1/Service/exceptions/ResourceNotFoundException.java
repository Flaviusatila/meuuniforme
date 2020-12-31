package com.example.estacionamentoPDS1.estacionamentoPDS1.Service.exceptions;

public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " +id);
    }

}
