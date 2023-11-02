package hexlet.code;
import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff", description = "Compares two configuration files and shows a difference.")
public class App implements Callable<String> {
    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested;

    @CommandLine.Option(names = { "-V", "--version" }, versionHelp = true, description = "Print version information and exit.")
    private boolean versionRequested;

    @CommandLine.Parameters(index = "0", description = "path to first file")
    private String filePath1;

    @CommandLine.Parameters(index = "1", description = "path to second file")
    private String filePath2;

    @CommandLine.Option(names = { "-f", "--format"}, description = "Output format [default: stylish]")
    private String format = "Stylish";

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new App());
        cmd.execute(args);
    }

    @Override
    public String call() throws Exception {
        String result = Differ.generate(filePath1, filePath1);
        return result;
    }
}
