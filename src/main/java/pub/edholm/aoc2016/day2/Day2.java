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
        System.out.println("Day 2:");
        System.out.println("\tPart 1: The bathroom code is " + day2.solvePart1("day2.input"));
        System.out.println("\tPart 2: The bathroom code is " + day2.solvePart2("day2.input"));
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

    private String solve(String resourceName, final Keypad keypad, final int startX, final int startY) {
        final List<String> input = IoUtils.readLines(resourceName);
        final List<List<Direction>> directions = getDirections(input);

        StringBuilder sb = new StringBuilder();

        Pair<Integer, Integer> coordinate = Pair.of(startX, startY);
        for (List<Direction> digit : directions) {
            for (Direction direction : digit) {
                coordinate = direction.move(coordinate, keypad);
            }
            sb.append(keypad.push(coordinate.getLeft(), coordinate.getRight()));
        }
        return sb.toString();

    }

    @Override
    public String solvePart1(String resourceName) {
        return solve(resourceName, new Keypad(), 1, 1);
    }

    @Override
    public String solvePart2(String resourceName) {
        String[][] weirdKeypad = new String[][] {
                {"", "",  "1", "",  ""},
                {"", "2", "3", "4", ""},
                {"5","6", "7", "8", "9"},
                {"", "A", "B", "C", ""},
                {"", "",  "D", "",  ""},
        };
        return solve(resourceName, new Keypad(weirdKeypad), 0, 2);
    }
}
