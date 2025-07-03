package com.studerw.datastructures.ch5;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Fibonacci {

    public static long fibonacci(int n) {
        checkBadArgs(n);
        if (n == 0) return 0L;
        if (n == 1) return 1L;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long fibonacciMemo(int n) {
        checkBadArgs(n);
        Map<Integer, Long> cache = new HashMap<>(Map.of(
                0, 0L,
                1, 1L));

        return fibonacciMemoPriv(n, cache);
    }

    private long fibonacciMemoPriv(int n, Map<Integer, Long> cache) {
        if (cache.containsKey(n)) {
            log.debug("Hit memo: {}", n);
            return cache.get(n);
        }

        long result = fibonacciMemoPriv(n - 1, cache) + fibonacciMemoPriv(n - 2, cache);

        cache.put(n, result);
        return result;
    }
    
    private static void checkBadArgs(int n) {
        // Check for negative input
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        // Handle potential overflow
        if (n >= 93) {
            throw new ArithmeticException("Fibonacci number exceeds Long.MAX_VALUE for n >= 93");
        }
    }

}
