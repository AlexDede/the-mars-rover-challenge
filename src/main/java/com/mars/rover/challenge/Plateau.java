package com.mars.rover.challenge;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Plateau {

    private static final int START_X = 0;
    private static final int START_Y = 0;

    private int endX;
    private int endY;

    public int getStartX() {
        return START_X;
    }

    public int getStartY() {
        return START_Y;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

}
