package com.wng.jenkin.ex;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String mesg) {
        super(mesg);
    }
}
