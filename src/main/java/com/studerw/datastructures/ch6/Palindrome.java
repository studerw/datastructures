package com.studerw.datastructures.ch6;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class Palindrome {

    // This is time of O(n). If we didn't use a StringBuilder, but instead used String concatenation
    // then we'd get O(n^2)
    public static boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) throw new IllegalArgumentException("Input cannot be null or empty.");
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.add(input.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.removeLast());
        }
        log.debug("input: {}, reversed: {}", input, sb.toString());
        return sb.toString().equals(input);

    }
}
