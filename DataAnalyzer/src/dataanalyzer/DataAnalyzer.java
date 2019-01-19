/*
 * Free for educational purposes
 */
package dataanalyzer;

import java.util.ArrayList;
import java.util.List;
import dataanalyzer.DataAnalyzer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Maintains a collection of floating-point numbers to compute
 * their average, minimum, and maximum.
 * @author janet
 */
public class DataAnalyzer {

    private List<Double> collection;
    
    /**
     * Create a new DataAnalyzer
     */
    public DataAnalyzer() {
        collection = new ArrayList<Double>();
    }
    
    /** 
     * Adds a number to the collection
     * @param number the number to add
     */
    public void add(double number) {
        collection.add(number);
    }
    
    /**
     * Averages the numbers in the collection
     * @return the average
     * @throws NoDataException if there is no data to average
     */
    public double average() throws NoDataException {
        if (collection.isEmpty()) {
            throw new NoDataException();
        }
        
        double sum = 0;
        for (double val : collection) {
            sum += val;
        }
        return sum / collection.size();
    }

    /**
     * Test program for the DataAnalyzer
     * @param args ignored
     */
    public static void main(String[] args) {
        DataAnalyzer analyzer = new DataAnalyzer();
        analyzer.add(12.0);
        analyzer.add(0.0);
        analyzer.add(16.0);
        analyzer.add(20.2);
        try {
            System.out.println("Average: " + analyzer.average());
            // System.out.println("Minimum: " + analyzer.min());
            // System.out.println("Maximum: " + analyzer.max());
        } catch (NoDataException ex) {
            Logger.getLogger(DataAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
