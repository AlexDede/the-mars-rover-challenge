package com.mars.rover.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordinateTest {

    @Test
    void createTest() {
        Coordinate coordinate = new Coordinate(1, 2);
        Assertions.assertEquals(1, coordinate.getX());
        Assertions.assertEquals(2, coordinate.getY());
    }

}