package com.mars.rover.challenge;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@EqualsAndHashCode
public class Position {

    private Coordinate coordinate;
    private Direction direction;

    public Position(int x, int y, String direction) {
        this(x, y, Direction.parse(direction));
    }

    public Position(int x, int y, Direction direction) {
        this(new Coordinate(x, y), direction);
    }

    public Position(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return StringUtils.joinWith(StringUtils.SPACE, coordinate.getX(), coordinate.getY(), direction);
    }
}
