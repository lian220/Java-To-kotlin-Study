package com.group.libraryapp.calculator

import com.group.libraryapp.calculator.Calculator
import kotlin.IllegalStateException


fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.minusTest()
    calculatorTest.multiplyTest()
    calculatorTest.divideTest()
    calculatorTest.diveExceptionTest()
}

class CalculatorTest {

    fun addTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.add(3)

        // then
        if(calculator.number != 8) {
            throw AssertionError("add 함수의 결과가 다릅니다.")
        }
    }

    fun minusTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.minus(3)

        // then
        if(calculator.number != 2) {
            throw AssertionError("minus 함수의 결과가 다릅니다.")
        }
    }

    fun multiplyTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.muliply(3)

        // then
        if(calculator.number != 15) {
            throw AssertionError("multiply 함수의 결과가 다릅니다.")
        }
    }

    fun divideTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.divide(2)

        // then
        if(calculator.number != 2) {
            throw AssertionError("divide 함수의 결과가 다릅니다.")
        }
    }

    fun diveExceptionTest() {
        //given
        val calculator = Calculator(5)

        //when
        try {
            calculator.divide(0)
        } catch (e: IllegalArgumentException) {
            if(e.message != "0으로 나눌 수 없습니다.") {
                throw IllegalArgumentException("메시지가 다릅니다.")
            }
            //test success!!
            return
        } catch (e: Exception) {
            throw IllegalStateException()
        }
        throw IllegalStateException("기대하는 예외가 발생하지 않았습니다.")
    }

}