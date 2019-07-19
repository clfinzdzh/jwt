package com.ems.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.charset.Charset;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Throwable.class)
    public ResponseEntity responseEntity(Throwable throwable) {
        String js = "这是放的是要发送的html文本";
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("text", "html", Charset.forName("utf-8"));
        headers.setContentType(mediaType);
        return new ResponseEntity<>(js, headers, HttpStatus.OK);
    }
}
