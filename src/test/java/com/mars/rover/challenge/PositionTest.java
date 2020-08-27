package com.mars.rover.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void parseDirection() {
        Position position = new Position(0, 1, "E");
        Assertions.assertEquals(0, position.getCoordinate().getX());
        Assertions.assertEquals(1, position.getCoordinate().getY());
        Assertions.assertEquals(Direction.EAST, position.getDirection());
    }

    @Test
    void withParsedDirection() {
        Position position = new Position(0, 1, Direction.EAST);
        Assertions.assertEquals(0, position.getCoordinate().getX());
        Assertions.assertEquals(1, position.getCoordinate().getY());
        Assertions.assertEquals(Direction.EAST, position.getDirection());
    }

}