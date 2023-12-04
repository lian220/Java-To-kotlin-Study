package com.group.libraryapp.dto.book

import com.group.libraryapp.domain.book.BookType

data class BookStatResponse(
        val type: BookType,
        val count: Long,
) {
//    fun plusOne() {
//        count++
//    }
}