package hexlet.code;
import hexlet.code.Differ;
import picocli.CommandLine;

import java.io.File;

@CommandLine.Command(name = "gendiff", description = "Compares two configuration files and shows a difference.")
public class App implements Runnable{
    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested;

    @CommandLine.Option(names = { "-V", "--version" }, versionHelp = true, description = "Print version information and exit.")
    private boolean versionRequested;

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new App());
        cmd.execute(args);
    }

    @Override
    public void run() {
        if (helpRequested) {
            CommandLine.usage(this, System.out);
        } else if (versionRequested) {
            System.out.println("Version 1.0");
        } else {
            System.out.println("Running the diff operation...");
        }
    }
}
