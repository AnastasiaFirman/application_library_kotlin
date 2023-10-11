package org.anastasia.library.exception.exceptionhandler

import org.anastasia.library.exception.BookNotFoundException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class BookInfoExceptionHandler {
    @ExceptionHandler(BookNotFoundException::class)
    fun handlerBookNotFoundException(): String {
        return "Книга с таким id не найдена"
    }
}