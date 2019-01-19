/*
 * Free for educational purposes
 */
package dataanalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Inputs numbers from a user and computes their average, minimum, and maximum.
 * We wanted the classes to have an inheritance relationship.
 * @author janet
 */
public class InputDataAnalyzer extends DataAnalyzer {
    
    /**
     * Get data from the user.
     * @throws IOException
     */
    private void inputData() throws IOException {
        BufferedReader console = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter floating point numbers, one per line.");
        System.out.println("Enter a blank line to finish.");
            
        String input;
        do { 
            input = console.readLine();
            try {
                add(Double.parseDouble(input)); 
            } catch (NumberFormatException ex) {
                if (!input.isEmpty()) {
                    System.out.println("That's not a number. Try again");
                }
            }
        } while (!input.isEmpty());
    }
    
    /**
     * The main function
     * @param args ignored
     */
    public static void main(String[] args) {
        try {
            InputDataAnalyzer analyzer = new InputDataAnalyzer();
            analyzer.inputData();
            System.out.println("Average: " + analyzer.average());
        } catch (NoDataException ex) {
            System.out.println("No data entered");
        } catch (IOException ex) {
            Logger.getLogger(InputDataAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
