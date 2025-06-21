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
    void addToEmptyGameboard() {
       final Scoreboard scoreboard =  new Scoreboard(3);
       scoreboard.add(new GameEntity("bill", 1));
       assertThat(scoreboard.getNumEntities()).isEqualTo(1);
       assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
    }

    @Test
    void addToPartiallyFullGameboard() {
        final Scoreboard scoreboard =  new Scoreboard(4);
        scoreboard.add(new GameEntity("bill", 5));
        scoreboard.add(new GameEntity("bob", 1));

        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(2);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("bob");

        log.debug("{}", scoreboard);
        scoreboard.add(new GameEntity("james", 3));
        assertThat(scoreboard.getNumEntities()).isEqualTo(3);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("james");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("bob");
    }

    @Test
    void addToFullGameboard() {
        final Scoreboard scoreboard =  new Scoreboard(3);
        scoreboard.add(new GameEntity("bill", 5));
        scoreboard.add(new GameEntity("bob", 1));
        scoreboard.add(new GameEntity("james", 3));

        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(3);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("james");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("bob");

        scoreboard.add(new GameEntity("mary", 4));
        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(3);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("mary");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("james");

        scoreboard.add(new GameEntity("larry", 3));
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("mary");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("james");
    }

    @Test
    void addToFullGameboardThatIsLessThanLowScore() {
        final Scoreboard scoreboard =  new Scoreboard(3);
        scoreboard.add(new GameEntity("bill", 5));
        scoreboard.add(new GameEntity("bob", 2));
        scoreboard.add(new GameEntity("james", 3));

        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(3);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("james");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("bob");

        scoreboard.add(new GameEntity("mary", 2));
        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(3);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("james");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("bob");

        scoreboard.add(new GameEntity("larry", 1));
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("james");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("bob");
    }

    @Test
    public void removeInvalidIndex(){
        assertThrows(IllegalArgumentException.class, () -> {
            final Scoreboard scoreboard =  new Scoreboard(3);
            scoreboard.remove(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final Scoreboard scoreboard =  new Scoreboard(3);
            scoreboard.remove(3);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final Scoreboard scoreboard =  new Scoreboard(1);
            scoreboard.add(new GameEntity("larry", 1));
            scoreboard.remove(3);
        });
    }

    @Test
    public void removeFromPartiallyFull() {
        final Scoreboard scoreboard =  new Scoreboard(4);
        scoreboard.add(new GameEntity("bill", 5));
        scoreboard.add(new GameEntity("bob", 2));
        scoreboard.add(new GameEntity("james", 3));

        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(3);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("james");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("bob");

        scoreboard.remove(0);
        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(2);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("james");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("bob");
    }

    @Test
    public void removeFromFullGameboard() {
        final Scoreboard scoreboard =  new Scoreboard(4);
        scoreboard.add(new GameEntity("bill", 5));
        scoreboard.add(new GameEntity("bob", 2));
        scoreboard.add(new GameEntity("mary", 4));
        scoreboard.add(new GameEntity("james", 3));

        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(4);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("mary");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("james");
        assertThat(scoreboard.getBoard()[2].getName()).isEqualTo("bob");

        scoreboard.remove(2);
        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(3);
        assertThat(scoreboard.getBoard()[0].getName()).isEqualTo("bill");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("mary");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("bob");

        scoreboard.remove(0);
        log.debug("{}", scoreboard);
        assertThat(scoreboard.getNumEntities()).isEqualTo(2);
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("mary");
        assertThat(scoreboard.getBoard()[1].getName()).isEqualTo("bob");
    }
}
