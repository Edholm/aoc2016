package pub.edholm.aoc2016.day6;

import pub.edholm.aoc2016.Aoc;
import pub.edholm.aoc2016.utils.IoUtils;

import java.util.*;

/**
 * Created by Emil Edholm on 2016-12-12.
 */
public class Day6 implements Aoc {
    public static void main(String[] args) {
        final Day6 day6 = new Day6();

        System.out.println("Day 6:");
        System.out.println("\tPart 1: " + day6.solvePart1("day6.input"));
        System.out.println("\tPart 2: " + day6.solvePart2("day6.input"));
    }

    private List<Map<Character, Integer>> initList() {
        List<Map<Character, Integer>> frequencyList = new ArrayList<>(6);
        for (int i = 0; i < 8; i++) {
            frequencyList.add(new HashMap<>());
        }
        return frequencyList;
    }

    private String solve(String resourceName, boolean reverseOrder) {
        final List<String> input = IoUtils.readLines(resourceName);
        final List<Map<Character, Integer>> freqList = initList();

        for (String s : input) {
            char[] charArray = s.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                final Map<Character, Integer> charMap = freqList.get(j);
                char c = charArray[j];
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Map<Character, Integer> charMap : freqList) {
            final String s = charMap.entrySet()
                    .stream()
                    .sorted((v1, v2) -> {
                        if(!reverseOrder) {
                            return Integer.compare(v1.getValue(), v2.getValue());
                        }
                        return Integer.compare(v2.getValue(), v1.getValue());
                    })
                    .findFirst()
                    .map(e -> e.getKey().toString())
                    .orElse("");
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    @Override
    public String solvePart1(String resourceName) {
        return solve(resourceName, true);
    }

    @Override
    public String solvePart2(String resourceName) {
        return solve(resourceName, false);
    }
}
