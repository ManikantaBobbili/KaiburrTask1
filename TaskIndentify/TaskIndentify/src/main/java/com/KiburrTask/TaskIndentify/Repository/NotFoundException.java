package com.KiburrTask.TaskIndentify.Repository;

import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus

public class NotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
