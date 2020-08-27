package com.mars.rover.challenge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarsRoverChallengeResolverTest {

    MarsRoverChallengeResolver resolver = new MarsRoverChallengeResolver();

    @Test
    void resolveOneMarsRover() throws Exception {
        String output = tapSystemOut(() -> resolver.resolve(Arrays.asList("5 5", "1 2 N", "LMLMLMLMM")));

        assertEquals("1 3 N", output.trim());
    }

    @Test
    void outOfThePlateauSize() {
        assertThrows(IllegalStateException.class, () -> resolver.resolve(Arrays.asList("5 5", "1 2 N", "LMLMLMLMMRMMMLLRRRRRRMMMR")));
    }

    @Test
    void resolveOneMarsRoverLongInstruction() throws Exception {
        String output = tapSystemOut(() -> resolver.resolve(Arrays.asList("5 5", "1 2 N", "LMLMLMLMMRMMMLLRRRRLMMMRMMMMRMMMMMRMMMMMRMMMMMRMMMMMRMMMRMMM")));

        assertEquals("3 3 E", output.trim());
    }

    @Test
    void resolveTwoMarsRovers() throws Exception {
        String output = tapSystemOut(() -> resolver.resolve(Arrays.asList("5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM")));

        assertEquals("1 3 N\n5 1 E", output.trim());
    }

    @Test
    void resolveTwoMarsRoversOneTheSameStartPositionWithDifferentInstructions() throws Exception {
        String output = tapSystemOut(() -> resolver.resolve(Arrays.asList("5 5", "1 2 N", "LMLMLMLMM", "1 2 N", "RRMLMLMLMM")));
        assertEquals("1 3 N\n0 2 W", output.trim());
    }

    @Test
    void startPositionAlreadyTaken() {
        assertThrows(IllegalStateException.class, () -> resolver.resolve(Arrays.asList("5 5", "1 2 N", "LMLMLMLMM", "1 3 N", "LMLMLMLMM")));
    }

    @Test
    void twoMarsRoversOnTheSameStartPositionAndTheSameInstructions() {
        assertThrows(IllegalStateException.class, () -> resolver.resolve(Arrays.asList("5 5", "1 2 N", "LMLMLMLMM", "1 2 N", "LMLMLMLMM")));
    }
}