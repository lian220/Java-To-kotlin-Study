package com.group.libraryapp.calculator

//public 는 setter, getter 모두 허용
//internal 은 setter, getter 모두 허용하지 않음
//하지만 setter을 열어두되 사용하지 않는 방향으로 해야 한다.

class Calculator(var number: Int) {
    fun add(operand: Int) {
        this.number += operand
    }

    fun minus(operand: Int) {
        this.number -= operand
    }

    fun muliply(operand: Int) {
        this.number *= operand
    }
    fun divide(operand: Int) {
        if( operand == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        this.number /= operand
    }
}

