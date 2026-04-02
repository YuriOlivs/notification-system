package com.yuriolivs.herald.shared.exceptions.http;

public class HttpForbiddenException extends HttpException {

    public HttpForbiddenException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}

