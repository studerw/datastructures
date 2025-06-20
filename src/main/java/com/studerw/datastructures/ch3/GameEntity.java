package com.studerw.datastructures.ch3;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class GameEntity {
    private String name;
    private int score;

    GameEntity(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("score", score)
                .toString();
    }
}
