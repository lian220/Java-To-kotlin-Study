package com.group.libraryapp.domain.book

import com.group.libraryapp.dto.book.BookStatResponse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface BookRepository: JpaRepository<Book, Long> {
    fun findByName(bookName: String): Book?

    @Query("SELECT NEW com.group.libraryapp.dto.book.BookStatResponse(b.type, count(b.id)) " +
        " FROM Book b GROUP BY b.type")
    fun getStatus(): List<BookStatResponse>
}