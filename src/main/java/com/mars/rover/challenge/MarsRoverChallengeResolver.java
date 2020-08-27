package com.mars.rover.challenge;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MarsRoverChallengeResolver {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Please, specify a path to the file with input data for the challenge");
            System.exit(-1);
        }
        Path path = Paths.get(args[0]);
        if (!Files.isRegularFile(path)) {
            System.err.println("Invalid file specified");
            System.exit(-1);
        }
        new MarsRoverChallengeResolver().resolve(Files.readAllLines(path).stream().filter(StringUtils::isNoneEmpty).collect(Collectors.toList()));
    }

    public void resolve(List<String> input) {
        Plateau plateau = createPlateau(input.get(0));
        Set<Coordinate> takenCoordinates = new LinkedHashSet<>();
        for (int i = 1; i < input.size(); i += 2) {
            MarsRover marsRover = new MarsRover(plateau, takenCoordinates);
            marsRover.takePosition(input.get(i));
            Position finalPosition = marsRover.processInstructions(input.get(i + 1));
            takenCoordinates.add(finalPosition.getCoordinate());
            System.out.println(finalPosition);
        }
    }

    private Plateau createPlateau(String plateau) {
        String[] coordinates = plateau.split(" ");
        return new Plateau(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }

}
