package com.yuriolivs.herald.shared.exceptions.http;

public class HttpUnauthorizedException extends HttpException{
    public HttpUnauthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
