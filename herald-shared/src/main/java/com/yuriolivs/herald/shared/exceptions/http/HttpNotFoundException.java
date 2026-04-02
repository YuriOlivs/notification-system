package com.yuriolivs.herald.shared.exceptions.http;

public class HttpNotFoundException extends HttpException {

    public HttpNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

