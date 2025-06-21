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

    public int getNumEntities() {
        return numEntities;
    }

    public GameEntity[] getBoard() {
        return board;
    }

    /**
     *
     * @param entity add to the board if a slot exists or if the entity.score is greater than the current lowest score in the list. Otherwise, the entity is not added.
     */
    public void add(GameEntity entity) {
        // if the board is full and the entity.score is less than or equal to the least high score, then just return
        if (board.length == numEntities && entity.getScore() <= board[numEntities - 1].getScore()) {
            log.info("Entity: {} is not greater than low score: {}, not adding to list.", entity, board[numEntities - 1]);
            return;
        }

        // if there are still board slots open, then we know we're increasing the numEntities,
        // and this also allows us to set the comparison pointer to the correct slot - either the first empty slot if slots still exist
        // or the last slot (we know that we're higher than this slot, which we're bumping out of the list, due to the if check above).
        if (numEntities < board.length) {
            numEntities++;
        }

        // We set the current pointer to the "end" of the list based on the numEntities.
        // Due to the IF comparison right above, we know we're comparing it to the last entity if there are still slots open (which we're pointing to now due to increasing numEntities),
        // or if the board is full, then we know we're higher than the last one due to the first IF, and so we can set the pointer to that (due to numEntities not increasing) and begin to compare with
        // the rest of the list's entities since we KNOW the current end entity is being bumped off.
        int ptr = numEntities - 1;
        while (ptr > 0 && entity.getScore() > board[ptr - 1].getScore()) {
            board[ptr] = board[ptr - 1];
            ptr--;
        }
        // if we got here, we know we're inserting the entity wherever the WHILE loop left off
        board[ptr] = entity;
    }

    /**
     *
     * @param i index of board to remove
     */
    public void remove(int i) {
        if (i < 0 || i >= (numEntities -1)) {
            log.warn("Cannot remove index: {} from a board of {} entities.",  i, numEntities);
            throw new IllegalArgumentException("Index out of range");
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("numEntities", numEntities)
                .append("board", board)
                .toString();
    }
}
