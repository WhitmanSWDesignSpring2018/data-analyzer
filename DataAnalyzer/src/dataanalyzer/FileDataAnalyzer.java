/*
 * Free for educational purposes
 */
package dataanalyzer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Reads floating-point numbers from a file, one per line, and reports their
 * average, minimum, and maximum.
 * @author janet
 */
public class FileDataAnalyzer extends DataAnalyzer {
    
    /**
     * Reads data from a file, one floating-point number per line.
     * Non-numeric data is ignored.
     * @param filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void readData(String filename) throws FileNotFoundException, IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line = in.readLine();
            while (line != null) {
                try {
                    add(Double.parseDouble(line));
                } catch (NumberFormatException ex) {
                    // Ignore
                }
                line = in.readLine();
            }
        } 
    }
    
    /**
     * Reads and analyzes data from a file.
     * @param args Expects the filename as a command-line argument.
     */
    public static void main(String[] args) {
        try {
            FileDataAnalyzer analyzer = new FileDataAnalyzer();
            analyzer.readData(args[0]);
            System.out.println("Average: " + analyzer.average());
        } catch (ArrayIndexOutOfBoundsException ex) {
            // Note this is an unchecked exception we wish to catch
            // in case a filename was not provided
            System.out.println("Usage: java FileDataAnalyzer <datafile>");
        } catch (FileNotFoundException ex) {
            System.out.println("File " + args[0] + " not found");
        } catch (NoDataException ex) {
            System.out.println("File " + args[0] + " does not contain numeric data");
        } catch (IOException ex) {
            Logger.getLogger(FileDataAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
