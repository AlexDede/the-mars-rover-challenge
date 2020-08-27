package com.mars.rover.challenge;

import java.util.Set;

import static com.mars.rover.challenge.Direction.*;

public class MarsRover {

    private final Plateau plateau;
    private final Set<Coordinate> takenCoordinates;
    private Position position;

    public MarsRover(Plateau plateau, Set<Coordinate> takenCoordinates) {
        this.plateau = plateau;
        this.takenCoordinates = takenCoordinates;
    }

    public void takePosition(String position) {
        String[] positionParts = position.split(" ");
        int xCoordinate = Integer.parseInt(positionParts[0]);
        int yCoordinate = Integer.parseInt(positionParts[1]);
        Position startPosition = new Position(xCoordinate, yCoordinate, positionParts[2]);
        if (!isInsidePlateau(startPosition.getCoordinate())) {
            throw new IllegalStateException("Can take position. Out of the plateau size");
        } else if (isTakenCoordinate(startPosition.getCoordinate())) {
            throw new IllegalStateException("Can take position. Position has already taken");
        }
        this.position = startPosition;
    }

    public Position processInstructions(String instructions) {
        if (this.position == null) {
            throw new IllegalStateException("Can process instruction. No position");
        }
        instructions.chars().mapToObj(c -> (char) c).forEach(this::processInstruction);
        return position;
    }

    private void processInstruction(Character instruction) {
        switch (instruction) {
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            case 'M':
                move();
                break;
            default:
                throw new IllegalArgumentException("Not supported instruction: " + instruction);
        }
    }

    private void turnLeft() {
        position = new Position(position.getCoordinate(), position.getDirection().getLeftDirection());
    }

    private void turnRight() {
        position = new Position(position.getCoordinate(), position.getDirection().getRightDirection());
    }

    private void move() {
        Coordinate currentCoordinate = position.getCoordinate();
        Coordinate newCoordinate;
        switch (position.getDirection()) {
            case EAST:
                newCoordinate = new Coordinate(currentCoordinate.getX() + 1, currentCoordinate.getY());
                break;
            case WEST:
                newCoordinate = new Coordinate(currentCoordinate.getX() - 1, currentCoordinate.getY());
                break;
            case NORTH:
                newCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() + 1);
                break;
            case SOUTH:
                newCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1);
                break;
            default:
                throw new IllegalArgumentException("Not supported direction: " + position.getDirection());
        }
        if (!isInsidePlateau(newCoordinate)) {
            throw new IllegalStateException("Can not move Rover. Out of the plateau size");
        } else if (isTakenCoordinate(newCoordinate)) {
            throw new IllegalStateException("Can not move Rover. Position has already taken");
        }
        position = new Position(newCoordinate, position.getDirection());
    }

    private boolean isTakenCoordinate(Coordinate coordinate) {
        return takenCoordinates.contains(coordinate);
    }

    private boolean isInsidePlateau(Coordinate p) {
        return p.getX() >= plateau.getStartX()
                && p.getX() <= plateau.getEndX()
                && p.getY() >= plateau.getStartY()
                && p.getY() <= plateau.getEndY();
    }

}
