package com.c1.q2.exception;

public class ItemDoesNotExistException extends Exception
{
    public ItemDoesNotExistException(int id) {
        super("No item exists with id " + id);
    }
}