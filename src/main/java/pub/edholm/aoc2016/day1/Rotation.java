package pub.edholm.aoc2016.day1;

/**
 * Created by Emil Edholm on 2016-12-09.
 */
public enum Rotation {
    North(0, 1),
    East(1, 0),
    South(0, -1),
    West(-1, 0);

    private final static Rotation[] values = Rotation.values();
    private final int x, y;

    Rotation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getXModifier() {
        return x;
    }

    public int getYModifier() {
        return y;
    }

    public Rotation right() {
        return values[(this.ordinal()+1) % values.length];
    }

    public Rotation left() {
        int ordinal = ordinal() - 1;
        return values[(ordinal >= 0) ? ordinal : values.length-1];
    }
}
