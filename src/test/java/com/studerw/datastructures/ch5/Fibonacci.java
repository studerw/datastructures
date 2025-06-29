package com.studerw.datastructures.ch5;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Fibonacci {

    public Map<Integer, Long> memo = new HashMap<>(Map.of(
            0, 0L,
            1, 1L));

    public static void checkBadArgs(int n) {
        // Check for negative input
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        // Handle potential overflow
        if (n >= 93) {
            throw new ArithmeticException("Fibonacci number exceeds Long.MAX_VALUE for n >= 93");
        }
    }

    public static long fibonacci(int n) {
        checkBadArgs(n);
        if (n == 0) return 0L;
        if (n == 1) return 1L;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long fibonacciMemo(int n) {
        checkBadArgs(n);
        if (memo.containsKey(n)) {
            log.debug("Hit memo: {}", n);
            return memo.get(n);
        }

        long result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);

        memo.put(n, result);
        return result;
    }
}
