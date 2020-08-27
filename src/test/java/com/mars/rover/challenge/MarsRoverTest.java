package com.mars.rover.challenge;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    @Test
    void processInstructions() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau, new LinkedHashSet<>());
        marsRover.takePosition("1 2 N");

        assertEquals(new Position(new Coordinate(1, 3), Direction.NORTH), marsRover.processInstructions("LMLMLMLMM"));
    }

}