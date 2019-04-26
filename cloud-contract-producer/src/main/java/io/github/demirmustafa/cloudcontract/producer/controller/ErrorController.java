package io.github.demirmustafa.cloudcontract.producer.controller;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mustafa Demir <mustafa.demir@sahabt.com>
 */
@ControllerAdvice
@Slf4j
public class ErrorController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorModel response(HttpServletRequest req, HttpServletResponse res, Exception ex) {
        log.error("An error occurred: {}", ex.getMessage());
        res.setStatus(HttpStatus.EXPECTATION_FAILED.value());
        return ErrorModel.builder()
                .ex(ex.getClass().getName())
                .message(ex.getMessage())
                .build();
    }

}


@Data
@Builder
class ErrorModel {
    private String ex;
    private String message;
}
