package com.studerw.datastructures.ch3;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScoreboardTest {
    private static final Logger log = LoggerFactory.getLogger(ScoreboardTest.class);

    @Test
    void testBadGameboard() {
        assertThrows(IllegalArgumentException.class, () -> {
            final Scoreboard scoreboard =  new Scoreboard(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            final Scoreboard scoreboard =  new Scoreboard(-1);
        });
    }

    @Test
    void testEmptyGameboard() {
       final Scoreboard scoreboard =  new Scoreboard(3);
       scoreboard.add(new GameEntity("bill", 1));
       assertThat(scoreboard.getNumEntities()).isEqualTo(1);
       assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
    }

    @Test
    void testPartiallyFullGameboard() {
        final Scoreboard scoreboard =  new Scoreboard(4);
        scoreboard.add(new GameEntity("bill", 5));
        scoreboard.add(new GameEntity("bob", 1));

        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(2);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bob");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("bill");

        log.debug("{}", scoreboard);
        scoreboard.add(new GameEntity("james", 3));
        assertThat(scoreboard.getNumEntities()).isEqualTo(3);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bob");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("james");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("bill");
    }

    @Test
    void testFullGameboard() {
        final Scoreboard scoreboard =  new Scoreboard(3);
        scoreboard.add(new GameEntity("bill", 5));
        scoreboard.add(new GameEntity("james", 3));
        scoreboard.add(new GameEntity("bob", 1));

        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(3);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bob");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("james");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("bill");

        scoreboard.add(new GameEntity("mary", 4));
        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(3);
        assertThat(scoreboard.getNumEntities()).isEqualTo(3);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bob");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("james");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("mary");
        assertThat(scoreboard.getBoard()[2].getScore()).isEqualTo(4);
    }
}
