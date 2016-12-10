package pub.edholm.aoc2016;

import pub.edholm.aoc2016.day1.Day1;
import pub.edholm.aoc2016.day2.Day2;
import pub.edholm.aoc2016.day3.Day3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Emil Edholm on 2016-12-10.
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<Class<? extends Aoc>> days = Arrays.asList(
                Day1.class,
                Day2.class,
                Day3.class);

        for (Class<? extends Aoc> day : days) {
            Method mainMethod = day.getMethod("main", String[].class);
            mainMethod.invoke(null, (Object) null);
        }
    }
}
