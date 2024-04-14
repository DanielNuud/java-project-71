package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;


public class Differ {

    public static String generate(String pathToFirstFile, String pathToSecondFile, String format) throws IOException {
        Map<Object, Object> firstData = Parser.parseContent(readFile(pathToFirstFile), getFormat(pathToFirstFile));
        Map<Object, Object> secondData = Parser.parseContent(readFile(pathToSecondFile), getFormat(pathToSecondFile));

        List<Map<Object, Object>> list = Tree.build(firstData, secondData);
        return Formatter.formatText(list, format);
    }

    public static String generate(String pathToFirstFile, String pathToSecondFile) throws IOException {
        return generate(pathToFirstFile, pathToSecondFile, "stylish");
    }

    public static String readFile(String path) throws IOException {
        return Files.readString(Path.of(path).toAbsolutePath().normalize());
    }

    public static String getFormat(String path) {
        return path.substring(path.lastIndexOf(".") + 1);
    }
}
