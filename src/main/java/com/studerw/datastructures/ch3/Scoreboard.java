package com.studerw.datastructures.ch3;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example of a sorted list with an "add" method using underlying array
 */
public class Scoreboard {
    private static final Logger log = LoggerFactory.getLogger(Scoreboard.class);
    private int numEntities;
    private GameEntity[] board;

    public Scoreboard(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        this.board = new GameEntity[capacity];
    }

    public void add(GameEntity entity) {
        // empty
        if (numEntities == 0) {
            board[0] = entity;
            ++numEntities;
            return;
        }

        // full and current is not less than least high score
        if (board.length == numEntities && board[numEntities - 1].getScore() < entity.getScore()) {
            log.warn("Entity: {} is not less than low score: {}, not adding to list.", entity, board[numEntities - 1]);
        }

        // not empty but not full
        // if (board.length > numEntities) {
        int current = numEntities;
        while (current > 0 && entity.getScore() < board[current - 1].getScore()) {
            // we can't shove the last place entity outside the index of the array, so it just gets thrown away
            if (current < board.length) {
                board[current] = board[current - 1];
            }

            current--;
        }
        // if this one was inserted into the list
        if (current != numEntities) {
            board[current] = entity;
        }
        if (board.length > numEntities && current != numEntities) {
            numEntities++;
        }
    }

    public int getNumEntities() {
        return numEntities;
    }

    public GameEntity[] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("numEntities", numEntities)
                .append("board", board)
                .toString();
    }
}
