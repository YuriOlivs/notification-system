package com.yuriolivs.herald.shared.exceptions.http;

public class HttpException extends RuntimeException {
    private final HttpStatus status;

    public HttpException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
