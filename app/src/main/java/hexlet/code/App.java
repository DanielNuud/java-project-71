package hexlet.code;
import picocli.CommandLine;

import java.util.concurrent.Callable;
/**
 * Compares two configuration files and shows a difference.
 */
@CommandLine.Command(name = "gendiff", description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true,
            description = "Show this help message and exit.")
    private boolean helpRequested;

    @CommandLine.Option(names = { "-V", "--version" }, versionHelp = true,
            description = "Print version information and exit.")
    private boolean versionRequested;

    @CommandLine.Parameters(index = "0", description = "path to first file")
    private String filePath1;

    @CommandLine.Parameters(index = "1", description = "path to second file")
    private String filePath2;

    @CommandLine.Option(names = { "-f", "--format"}, paramLabel = "format",
            description = "Output format [default: stylish]",
            defaultValue = "stylish")
    private String format;

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new App());
        cmd.execute(args);
    }
    /**
     * Executes the 'gendiff' command.
     *
     * @return the exit code
     * @throws Exception if an error occurs during execution
     */
    @Override
    public Integer call() throws Exception {
        Differ.generate(filePath1, filePath2, format);
        return null;
    }
}
