package pub.edholm.aoc2016.day2;

import org.apache.commons.lang3.tuple.Pair;
import pub.edholm.aoc2016.Aoc;
import pub.edholm.aoc2016.utils.IoUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Emil Edholm on 2016-12-10.
 */
public class Day2 implements Aoc {

    public static void main(String[] args) {
        final Day2 day2 = new Day2();
        System.out.print("Day 2, part 1: ");
        System.out.println(day2.solvePart1("day2.input"));

        System.out.print("Day 2, part 2: ");
        System.out.println(day2.solvePart2("day2.input"));
    }

    private List<List<Direction>> getDirections(List<String> input) {
        List<List<Direction>> directions = new ArrayList<>(input.size());

        for (String s : input) {
            final List<Direction> dirs = s
                    .chars().mapToObj(value -> (char) value)
                    .map(Direction::from)
                    .collect(Collectors.toList());
            directions.add(dirs);
        }
        return directions;
    }

    @Override
    public String solvePart1(String resourceName) {
        final List<String> input = IoUtils.readLines(resourceName);
        final List<List<Direction>> directions = getDirections(input);

        int[][] keypad = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8,  9}
        };

        StringBuilder sb = new StringBuilder();
        int x = 1, y = 1;
        for (List<Direction> digit : directions) {
            for (Direction direction : digit) {
                Pair<Integer, Integer> newCoord = direction.move(x, y);
                x = newCoord.getLeft();
                y = newCoord.getRight();
            }
            sb.append(keypad[y][x]);
        }
        return sb.toString();
    }

    @Override
    public String solvePart2(String input) {
        return null;
    }
}
