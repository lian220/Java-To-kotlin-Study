package com.group.libraryapp.controller.book

import com.group.libraryapp.dto.book.BookLoanRequest
import com.group.libraryapp.dto.book.BookRequest
import com.group.libraryapp.dto.book.BookReturnRequest
import com.group.libraryapp.dto.book.BookStatResponse
import com.group.libraryapp.service.book.BookService
import org.springframework.web.bind.annotation.*

@RestController
class BookController(
    private val bookService: BookService,
) {
    @PostMapping("/book")
    fun saveBook(@RequestBody request: BookRequest) {
        bookService.saveBook(request)
    }

    @PostMapping("/book/loan")
    fun loanBook(@RequestBody request: BookLoanRequest) {
        bookService.loanBook(request)
    }

    @PutMapping("/book/return")
    fun returnBook(@RequestBody request: BookReturnRequest) {
        bookService.returnBook(request)
    }

    @GetMapping("/book/loan")
    fun countLoanedBook(): Int {
        return bookService.countLoanedBook()
    }

    @GetMapping("/book/stat")
    fun getBookStatistics(): List<BookStatResponse> {
        return bookService.getBookStatistics()
    }
}