package com.mars.rover.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlateauTest {

    private Plateau plateau;

    @BeforeEach
    void beforeEach() {
        plateau = new Plateau(5, 50);
    }

    @Test
    void getStartX() {
        Assertions.assertEquals(0, plateau.getStartX());
    }

    @Test
    void getStartY() {
        Assertions.assertEquals(0, plateau.getStartX());
    }

    @Test
    void getEndX() {
        Assertions.assertEquals(5, plateau.getStartX());
    }

    @Test
    void getEndY() {
        Assertions.assertEquals(50, plateau.getStartX());
    }
}