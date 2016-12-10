package pub.edholm.aoc2016.day3;

import pub.edholm.aoc2016.Aoc;
import pub.edholm.aoc2016.utils.IoUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Emil Edholm on 2016-12-10.
 */
public class Day3 implements Aoc {
    public static void main(String[] args) {
        final Day3 day3 = new Day3();
        System.out.println("Day 3:");
        System.out.println("\tPart 1: " + day3.solvePart1("day3.input"));
        System.out.println("\tPart 2: " + day3.solvePart2("day3.input"));
    }

    @Override
    public String solvePart1(String resourceName) {
        final List<String> rawTriangles = IoUtils.readLines(resourceName);
        final List<Triangle> triangles = rawTriangles.stream()
                .map(Triangle::valueOf)
                .filter(Triangle::isPossible)
                .collect(Collectors.toList());
        return triangles.size() + " valid triangles";
    }

    @Override
    public String solvePart2(String resourceName) {
        return null;
    }
}
