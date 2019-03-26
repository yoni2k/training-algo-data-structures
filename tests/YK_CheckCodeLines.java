import YK_Common.YK_Exception;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class YK_CheckCodeLines {

    private int getLinesInFile(File file) {

        int lines = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null) lines++;
            reader.close();
        }
        catch(Exception ex) {
            throw new YK_Exception(ex.getMessage());
        }

        System.out.println("\tFolder " + file.getName() + ", lines: " + lines);
        return lines;

    }

    private int getLinesInFolder(final File folder) {
        int linesInFolder = 0;

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                linesInFolder += getLinesInFolder(fileEntry);
            } else {
                linesInFolder += getLinesInFile(fileEntry);
            }
        }

        System.out.println("Folder " + folder.getName() + ", lines: " + linesInFolder);

        return linesInFolder;
    }

    @Test
    void printNumLines() {

        int linesSrc = 0;
        int linesTest = 0;

        File srcFolder = new File("src");

        for (final File fileEntry : srcFolder.listFiles()) {
            if (fileEntry.isDirectory()) {
                linesSrc += getLinesInFolder(fileEntry);
            } else {
                linesSrc += getLinesInFile(fileEntry);
            }
        }

        System.out.println("Total SOURCE lines: " + linesSrc);

        File testsFolder = new File("tests");

        for (final File fileEntry : testsFolder.listFiles()) {
            if (fileEntry.isDirectory()) {
                linesTest += getLinesInFolder(fileEntry);
            } else {
                linesTest += getLinesInFile(fileEntry);
            }
        }

        System.out.println("Total SOURCE lines: " + linesSrc);
        System.out.println("Total TEST lines: " + linesTest);
        System.out.println("Total lines: " + (linesSrc + linesTest));

    }
}
