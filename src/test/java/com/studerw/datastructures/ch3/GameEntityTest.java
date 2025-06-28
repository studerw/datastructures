package com.studerw.datastructures.ch3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameEntityTest {

    @Test
    void testEquals() {
        GameEntity one = new GameEntity("bill", 1);
        GameEntity two = new GameEntity("foo", 2);
        assertThat(one.equals(two)).isFalse();

        GameEntity three = new GameEntity("bill", 1);
        GameEntity four = new GameEntity("bill", 2);
        assertThat(three.equals(four)).isFalse();

        GameEntity five = new GameEntity("bob", 2);
        GameEntity six = new GameEntity("bill", 2);
        assertThat(five.equals(six)).isFalse();

        GameEntity seven = new GameEntity("bill", 2);
        GameEntity eight = new GameEntity("bill", 2);
        assertThat(seven.equals(eight)).isTrue();
    }
}