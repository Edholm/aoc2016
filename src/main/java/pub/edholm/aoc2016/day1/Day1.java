package pub.edholm.aoc2016.day1;

import pub.edholm.aoc2016.Aoc;
import pub.edholm.aoc2016.utils.IoUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Emil Edholm on 2016-12-08.
 */
public class Day1 implements Aoc {
    public static void main(String[] args) {
        String input = IoUtils.readFile("day1.input");
        final Day1 day1 = new Day1();
        System.out.println("Day 1:");
        System.out.println("\tPart 1: " + day1.solvePart1(input) + " blocks away");
        System.out.println("\tPart 2: " + day1.solvePart2(input) + " blocks away");
    }


    private List<Position> buildPositions(List<String> movements) {
        List<Position> positions = new ArrayList<>(movements.size());

        final Position initial = new Position();
        positions.add(initial);

        for (int i = 0; i < movements.size(); i++) {
            final Position newPos = positions.get(i).newAt(movements.get(i));
            positions.add(newPos);
        }
        return Collections.unmodifiableList(positions);
    }

    int calculateDistance(List<String> movements) {
        final List<Position> positions = buildPositions(movements);

        final Position initial = positions.get(0);
        final Position last = positions.get(positions.size() - 1);
        return initial.distanceTo(last);
    }

    private Position intersection(Position p1, Position p2, Position p3, Position p4) {
        int d =
                (p4.y - p3.y) * (p2.x - p1.x)
                        -
                        (p4.x - p3.x) * (p2.y - p1.y);

        int n_a =
                (p4.x - p3.x) * (p1.y - p3.y)
                        -
                        (p4.y - p3.y) * (p1.x - p3.x);

        int n_b =
                (p2.x - p1.x) * (p1.y - p3.y)
                        -
                        (p2.y - p1.y) * (p1.x - p3.x);

        double ua = n_a / (double) d;
        double ub = n_b / (double) d;

        if (ua >= 0d && ua <= 1d && ub >= 0d && ub <= 1d) {
            double X = p1.x + (ua * (p2.x - p1.x));
            double Y = p1.y + (ua * (p2.y - p1.y));
            return new Position((int) X, (int) Y, Rotation.North);
        }
        return null;
    }

    @Override
    public String solvePart1(String input) {
        List<String> parts = IoUtils.splitOn(input, ", ");
        return String.valueOf(calculateDistance(parts));
    }

    @Override
    public String solvePart2(String input) {
        final List<Position> ps = buildPositions(IoUtils.splitOn(input, ", "));
        Position inter;

        for (int i = 1; i < ps.size(); i++) {
            Position p1 = ps.get(i - 1);
            Position p2 = ps.get(i);
            for (int j = i + 2; j < ps.size(); j++) {
                Position p3 = ps.get(j - 1);
                Position p4 = ps.get(j);
                inter = intersection(p1, p2, p3, p4);

                if (inter != null) {
                    return String.valueOf(ps.get(0).distanceTo(inter));
                }
            }
        }
        return "Couldn't solve it!";
    }
}
