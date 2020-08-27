package com.mars.rover.challenge;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum Direction {

    EAST("E") {
        @Override
        public Direction getLeftDirection() {
            return Direction.NORTH;
        }

        @Override
        public Direction getRightDirection() {
            return Direction.SOUTH;
        }
    },
    WEST("W") {
        @Override
        public Direction getLeftDirection() {
            return SOUTH;
        }

        @Override
        public Direction getRightDirection() {
            return NORTH;
        }
    },
    NORTH("N") {
        @Override
        public Direction getLeftDirection() {
            return Direction.WEST;
        }

        @Override
        public Direction getRightDirection() {
            return Direction.EAST;
        }
    },
    SOUTH("S") {
        @Override
        public Direction getLeftDirection() {
            return Direction.EAST;
        }

        @Override
        public Direction getRightDirection() {
            return Direction.WEST;
        }
    };

    private final String name;


    Direction(String name) {
        this.name = name;
    }

    public abstract Direction getLeftDirection();

    public abstract Direction getRightDirection();

    public static Direction parse(String direction) {
        return Arrays.stream(Direction.values())
                .filter(d -> StringUtils.equalsAnyIgnoreCase(direction, d.name))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unknown Direction: " + direction));
    }

    @Override
    public String toString() {
        return name;
    }

}
