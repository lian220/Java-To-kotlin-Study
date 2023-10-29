package com.group.libraryapp.domain.book

enum class BookType {
    COMPUTER,
    ECONOMY,
    // 사회 분야는 2022-12-31 이후로 입고 되지 않는다.
    SOCIETY,
    LANGUAGE,
    SCIENCE,
    ;
}