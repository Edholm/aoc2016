package pub.edholm.aoc2016.day2;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by Emil Edholm on 2016-12-10.
 */
enum Direction {
    Up,
    Down,
    Left,
    Right;

    public Pair<Integer, Integer> move(final Pair<Integer, Integer> old, Keypad keypad) {
        final int oldX = old.getLeft();
        final int oldY = old.getRight();
        int newX = oldX;
        int newY = oldY;
        //System.out.printf("Moving %-5s from %s", this, keypad.push(oldX, oldY));
        switch (this) {
            case Up:
                newY = (oldY == 0) ? oldY : oldY - 1;
                break;
            case Down:
                newY = (oldY == keypad.height()-1) ? oldY : oldY + 1;
                break;
            case Left:
                newX = (oldX == 0) ? oldX : oldX - 1;
                break;
            case Right:
                newX = (oldX == keypad.length()-1) ? oldX : oldX + 1;
                break;
        }
        if (!keypad.isValidMove(newX, newY)) {
            newX = oldX;
            newY = oldY;
        }
        //System.out.printf(" -> %s\n", keypad.push(newX, newY));
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
