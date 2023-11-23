package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.TreeSet;


import static hexlet.code.Parser.readFileBySpeciality;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        final String defaultFormat = "stylish";
        return generate(filepath1, filepath2, defaultFormat);
    }

    public static String generate(String filePath1, String filePath2, String format) throws Exception {

        final String firstFileAbsolutePath = checkIsFileExistThenToAbsolutePath(filePath1);
        final String secondFileAbsolutePath = checkIsFileExistThenToAbsolutePath(filePath2);

        final TreeMap<String, Object> value1 = readFileBySpeciality(firstFileAbsolutePath, filePath1);
        final TreeMap<String, Object> value2 = readFileBySpeciality(secondFileAbsolutePath, filePath2);

        TreeSet<String> setKeys = new TreeSet<>(value1.keySet());
        setKeys.addAll(value2.keySet());

        return Formatter.makeFormat(value1, value2, format, setKeys);
    }

    private static String checkIsFileExistThenToAbsolutePath(String filePath) throws IOException {
        Path absoluteFilePath = Paths.get(filePath).toAbsolutePath().normalize();

        if (!Files.exists(absoluteFilePath)) {
            throw new IOException("'" + absoluteFilePath + "' does not exist.\nCheck it!");
        }
        return Files.readString(absoluteFilePath);
    }
}
