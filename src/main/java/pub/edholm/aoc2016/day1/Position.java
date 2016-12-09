package pub.edholm.aoc2016.day1;

/**
 * Created by Emil Edholm on 2016-12-09.
 */
public class Position {
    public final int x, y;
    private final Rotation rotation;

    public Position() {
        this(0, 0, Rotation.North);
    }

    public Position(int x, int y, Rotation rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public Position newAt(String movement) {
        Rotation newRotation = rotation;
        final String leftOrRight = movement.substring(0, 1);
        switch (leftOrRight) {
            case "R":
                newRotation = newRotation.right();
                break;
            case "L":
                newRotation = newRotation.left();
                break;
        }
        int amount = Integer.valueOf(movement.substring(1, movement.length()));

        final int newX = x + amount * newRotation.getXModifier();
        final int newY = y + amount * newRotation.getYModifier();
        return new Position(newX, newY, newRotation);
    }

    public int distanceTo(Position other) {
        return Math.abs(x - other.x) + Math.abs(y - other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        if (y != position.y) return false;
        return rotation == position.rotation;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (rotation != null ? rotation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %s)", x, y, rotation);
    }
}
