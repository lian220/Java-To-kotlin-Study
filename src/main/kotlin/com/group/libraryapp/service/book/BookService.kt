package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.book.BookLoanRequest
import com.group.libraryapp.dto.book.BookRequest
import com.group.libraryapp.dto.book.BookReturnRequest
import com.group.libraryapp.dto.book.BookStatResponse
import com.group.libraryapp.repository.BookQueryDslRepository
import com.group.libraryapp.repository.user.loanhistory.UserLoanHistoryQueryDslRepository
import com.group.libraryapp.util.fail
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val bookQueryDslRepository: BookQueryDslRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryQueryDslRepository
) {

  @Transactional
  fun saveBook(request: BookRequest) {
    val book = Book(request.name, request.type)
    bookRepository.save(book)
  }

  @Transactional
  fun loanBook(request: BookLoanRequest) {
    val book = bookRepository.findByName(request.bookName) ?: fail()
    if (userLoanHistoryRepository.find(request.bookName, UserLoanStatus.LOANED) != null) {
      throw IllegalArgumentException("진작 대출되어 있는 책입니다")
    }
    val user = userRepository.findByName(request.userName) ?: fail()
    user.loanBook(book)

  }

  @Transactional
  fun returnBook(request: BookReturnRequest) {
    val user = userRepository.findByName(request.userName) ?: fail()
    user.returnBook(request.bookName)
  }

  @Transactional(readOnly = true)
  fun countLoanedBook(): Int {
    return userLoanHistoryRepository.count(UserLoanStatus.LOANED).toInt()
  }

  @Transactional(readOnly = true)
  fun getBookStatistics(): List<BookStatResponse> {
    return bookQueryDslRepository.getStatus()
//    return bookRepository.findAll() // List<Book>
//        .groupBy { book -> book.type } //Map<BookType, List<Book>>
//        .map { (type, books) -> BookStatResponse(type, books.size) }
//    val results = mutableListOf<BookStatResponse>()
//    val books = bookRepository.findAll()
//    for (book in books) {
//      results.firstOrNull { dto -> book.type == dto.type }
//          ?. plusOne()
//          ?: results.add(BookStatResponse(book.type, 1))
//    }
//    return results
  }
}