package pub.edholm.aoc2016.day3;

import pub.edholm.aoc2016.Aoc;
import pub.edholm.aoc2016.utils.IoUtils;

import java.util.ArrayList;
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
        final List<String> input = IoUtils.readLines(resourceName);
        final List<String[]> linesAndCols = input.stream().map(s -> s.trim().split("\\s+")).collect(Collectors.toList());
        final List<Triangle> triangles = new ArrayList<>();

        List<String> col1 = new ArrayList<>(3);
        List<String> col2 = new ArrayList<>(3);
        List<String> col3 = new ArrayList<>(3);
        for (String[] columns : linesAndCols) {
            col1.add(columns[0]);
            col2.add(columns[1]);
            col3.add(columns[2]);

           if (col1.size() == 3) {
               final List<Integer> col1Ints = col1.stream().map(Integer::valueOf).collect(Collectors.toList());
               final List<Integer> col2Ints = col2.stream().map(Integer::valueOf).collect(Collectors.toList());
               final List<Integer> col3Ints = col3.stream().map(Integer::valueOf).collect(Collectors.toList());
               triangles.add(Triangle.valueOf(col1Ints));
               triangles.add(Triangle.valueOf(col2Ints));
               triangles.add(Triangle.valueOf(col3Ints));
               col1.clear();
               col2.clear();
               col3.clear();
           }
        }
        return triangles.stream().filter(Triangle::isPossible).count() + " valid triangles";
    }
}
