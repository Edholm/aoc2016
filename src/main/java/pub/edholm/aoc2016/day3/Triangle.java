package pub.edholm.aoc2016.day3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Emil Edholm on 2016-12-10.
 */
class Triangle {
    private final int a, b, c;

    private Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isPossible() {
        return a + b > c;
    }

    public static Triangle valueOf(String s) {
        String[] parts = s.trim().split("\\s+");
        final List<Integer> sides = Stream.of(parts)
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());
        return new Triangle(sides.get(0), sides.get(1), sides.get(2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (a != triangle.a) return false;
        if (b != triangle.b) return false;
        return c == triangle.c;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
