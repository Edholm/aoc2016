package pub.edholm.aoc2016.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.Validate.notEmpty;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * Created by Emil Edholm on 2016-12-08.
 */
public class IoUtils {
    private IoUtils() {
        throw new AssertionError("You can't do that, that's illegal!");
    }

    public static String readFile(String resourceName) {
        notEmpty(resourceName, "The supplied resource name cannot be empty");

        final URL resource = IoUtils.class.getClassLoader().getResource(resourceName);
        notNull(resource, "Could not find a resource named: %s", resourceName);
        try {
            final File resourceFile = new File(resource.toURI());
            return FileUtils.readFileToString(resourceFile, StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static List<String> splitOn(String src, String spitter) {
        return Arrays.asList(src.split(spitter));
    }
}
