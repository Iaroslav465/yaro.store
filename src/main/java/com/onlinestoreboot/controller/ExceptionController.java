package com.onlinestoreboot.controller;

import com.onlinestoreboot.exception.OutOfStockException;
import com.onlinestoreboot.exception.WrongPasswordException;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller responsible for handling exceptions
 */
@ControllerAdvice
@Log4j2
public class ExceptionController {

    /**
     * Handles Data Access Exception
     *
     * @param e DataAccessException
     * @return View
     */
    @ExceptionHandler(DataAccessException.class)
    public String dataAccessExceptionHandler(DataAccessException e) {
        log.error(e.getMessage(), e);
        return "exception/data_access";
    }

    /**
     * Handles Username Not Found Exception
     *
     * @param e UsernameNotFoundException
     * @return View
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    public String usernameNotFoundExceptionHandler(UsernameNotFoundException e) {
        log.error(e.getMessage(), e);
        return "exception/username_not_found";
    }

    /**
     * Handles Wrong Password Exception
     *
     * @param e WrongPasswordException
     * @return View
     */
    @ExceptionHandler(WrongPasswordException.class)
    public String wrongPasswordExceptionHandler(WrongPasswordException e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute("errorMessage", e.getErrorMessage());
        return "exception/wrong_password";
    }

    /**
     * Handles Out Of Stock Exception
     *
     * @param e OutOfStockException
     * @return View
     */
    @ExceptionHandler(OutOfStockException.class)
    public String outOfStockExceptionHandler(OutOfStockException e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute("errorCode", e.getErrorCode());
        model.addAttribute("errorMessage", e.getErrorMessage());
        return "exception/out_of_stock";
    }

    /**
     * Handles all other exceptions
     *
     * @param e Exception
     * @return View
     */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return "exception/unexpected";
    }
}
