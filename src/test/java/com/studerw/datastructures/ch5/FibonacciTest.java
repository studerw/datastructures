package com.studerw.datastructures.ch5;

import com.studerw.datastructures.TimedTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class FibonacciTest extends TimedTest {

    @Test
    void fibonacciNegOne() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
    }

    @Test
    void fibonacciMemoNegOne() {
        Fibonacci fibonacci = new Fibonacci();
        assertThrows(IllegalArgumentException.class, () -> fibonacci.fibonacciMemo(-1));
    }

    @Test
    void fibonacciOverflow() {
        assertThrows(ArithmeticException.class, () -> Fibonacci.fibonacci(93));
    }

    @Test
    void fibonacciMemoOverflow() {
        Fibonacci fibonacci = new Fibonacci();
        assertThrows(ArithmeticException.class, () -> fibonacci.fibonacciMemo(93));
    }

    @Test
    void fibonacciZero() {
        long result = Fibonacci.fibonacci(0);
        log.debug("Fibonacci result of {}: {}", 0, result);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void fibonacciOne() {
        long result = Fibonacci.fibonacci(1);
        log.debug("Fibonacci result of {}: {}", 1, result);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void fibonacciTwo() {
        long result = Fibonacci.fibonacci(2);
        log.debug("Fibonacci result of {}: {}", 2, result);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void fibonacciThree() {
        long result = Fibonacci.fibonacci(3);
        log.debug("Fibonacci result of {}: {}", 3, result);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void fibonacci10() {
        long result = Fibonacci.fibonacci(10);
        log.debug("Fibonacci result of {}: {}", 10, result);
        assertThat(result).isEqualTo(55);
    }

    @Test
    void fibonacci20() {
        long result = Fibonacci.fibonacci(20);
        log.debug("Fibonacci result of {}: {}", 20, result);
        assertThat(result).isEqualTo(6765);
    }

    @Test
    void fibonacci30() {
        long result = Fibonacci.fibonacci(30);
        log.debug("Fibonacci result of {}: {}", 30, result);
        assertThat(result).isEqualTo(832040);
    }

    @Test
    void fibonacci40() {
        long result = Fibonacci.fibonacci(40);
        log.debug("Fibonacci result of {}: {}", 40, result);
        assertThat(result).isEqualTo(102_334_155);
    }

    @Test
    @Disabled
    void fibonacci50() {
        long result = Fibonacci.fibonacci(50);
        log.debug("Fibonacci result of {}: {}", 50, result);
        assertThat(result).isEqualTo(12_586_269_025L);
    }

    @Test
    void fibonacci1Memo() {
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.fibonacciMemo(1);
        log.debug("Fibonacci result of {}: {}", 1, result);
        assertThat(result).isEqualTo(1L);
    }

    @Test
    void fibonacci30Memo() {
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.fibonacciMemo(30);
        log.debug("Fibonacci result of {}: {}", 30, result);
        assertThat(result).isEqualTo(832040);
    }

    @Test
    void fibonacci50Memo() {
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.fibonacciMemo(50);
        log.debug("Fibonacci result of {}: {}", 50, result);
        assertThat(result).isEqualTo(12_586_269_025L);
    }

    @Test
    void fibonacci92Memo() {
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.fibonacciMemo(92);
        log.debug("Fibonacci result of {}: {}", 92, result);
        assertThat(result).isEqualTo(7_540_113_804_746_346_429L);
    }
}