package pub.edholm.aoc2016.day2;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by Emil Edholm on 2016-12-10.
 */
public enum Direction {
    Up,
    Down,
    Left,
    Right;

    public Pair<Integer, Integer> move(int oldX, int oldY) {
        int[][] keypad = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8,  9}
        };
        int newX = oldX;
        int newY = oldY;
        //System.out.printf("Moving %-5s from %d", this, keypad[oldY][oldX]);
        switch (this) {
            case Up:
                newY = (oldY == 0) ? oldY : oldY - 1;
                break;
            case Down:
                newY = (oldY == 2) ? oldY : oldY + 1;
                break;
            case Left:
                newX = (oldX == 0) ? oldX : oldX - 1;
                break;
            case Right:
                newX = (oldX == 2) ? oldX : oldX + 1;
                break;
        }
        //System.out.printf(" -> %d\n", keypad[newY][newX]);
        return Pair.of(newX, newY);
    }

    /**
     * Parse a direction from a string such as U, D, L, or R
     */
    public static Direction from(String direction) {
        if (direction.length() != 1) {
            throw new IllegalArgumentException("Direction has wrong size. Expected 1, got " + direction.length());
        }

        final Direction[] values = values();
        for (Direction value : values) {
            if (value.toString().startsWith(direction)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown direction: " + direction);
    }

    public static Direction from(char direction) {
        return from(String.valueOf(direction));
    }
}
