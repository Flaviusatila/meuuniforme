package com.example.estacionamentoPDS1.estacionamentoPDS1.Service.exceptions;

//Classe de personalização e tratamento de erro caso erro ao buscar na base de dados
public class DataBaseException extends  RuntimeException{

    public DataBaseException(String msg){
        super(msg);
    }
}
