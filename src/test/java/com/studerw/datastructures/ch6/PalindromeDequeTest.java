package com.studerw.datastructures.ch6;

import com.studerw.datastructures.TimedTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class PalindromeDequeTest extends TimedTest {

    @Test
    public void palindromeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            PalindromeDeque.isPalindrome(null);});
        assertThrows(IllegalArgumentException.class, () -> {
            PalindromeDeque.isPalindrome("");});
    }

    @Test
    public void palindromeValidOne() {
        String input = "a";
        boolean isPalindrome = PalindromeDeque.isPalindrome(input);
        log.debug("isPalindrome - {}: {}", input, isPalindrome);
        assertThat(isPalindrome).isTrue();
    }

    @Test
    public void palindromeValidTwo() {
        String input = "aa";
        boolean isPalindrome = PalindromeDeque.isPalindrome(input);
        log.debug("isPalindrome - {}: {}", input, isPalindrome);
        assertThat(isPalindrome).isTrue();
    }

    @Test
    public void palindromeValidThree() {
        String input = "bob";
        boolean isPalindrome = PalindromeDeque.isPalindrome(input);
        log.debug("isPalindrome - {}: {}", input, isPalindrome);
        assertThat(isPalindrome).isTrue();
    }

    @Test
    public void palindromeValidLong() {
        String input = "tattarrattat";
        boolean isPalindrome = PalindromeDeque.isPalindrome(input);
        log.debug("isPalindrome - {}: {}", input, isPalindrome);
        assertThat(isPalindrome).isTrue();
    }

    @Test
    public void palindromeInvalidLong() {
        String input = "tattarrattatb";
        boolean isPalindrome = PalindromeDeque.isPalindrome(input);
        log.debug("isPalindrome - {}: {}", input, isPalindrome);
        assertThat(isPalindrome).isFalse();
    }

    @Test
    public void palindromeInvalidTwo() {
        String input = "bo";
        boolean isPalindrome = PalindromeDeque.isPalindrome(input);
        log.debug("isPalindrome - {}: {}", input, isPalindrome);
        assertThat(isPalindrome).isFalse();
    }

    @Test
    public void palindromeInvalidSix() {
        String input = "boobie";
        boolean isPalindrome = PalindromeDeque.isPalindrome(input);
        log.debug("isPalindrome - {}: {}", input, isPalindrome);
        assertThat(isPalindrome).isFalse();
    }
}
