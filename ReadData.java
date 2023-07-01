package cpularo_week12;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Cassian Pularo
 * @Assignment Name: cpularo_week12
 * @Date: Dec 4, 2022
 * @Subclass ReadData Description: subclass to hold methods to read data from
 * text file and find avg, min, max, std deviation
 */
//Imports
import java.util.Scanner;
import java.io.File;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collections;
//Begin Subclass ReadData

public class ReadData {

    private double avg;
    private double min;
    private double max;
    private double avg_copy;
    private double avgSqrdDiff;
    private double stdDev;
    ArrayList<Double> data;
    ArrayList<Double> stdDevData;

    /* constructor */
    public ReadData() {
        data = new ArrayList<>();
        stdDevData = new ArrayList<>();
    }

    /**
     * method setData: adds file elements to array list 'data' and calls other
     * set methods
     *
     * @param input
     */
    public void setData(Scanner input) {
        /* clear array list first */
        data.clear();
        /* hasNext() instead of hasNextLine() fixed file reading issue */
        while (input.hasNext()) {
            data.add(input.nextDouble());
        }
        setAvg(data);
        setMinMax();
        setStdDev();
    }

    /**
     * method getData: iterates through array list, displaying each element
     */
    public void getData() {
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }

    /**
     * method setAvg: calculates avg of array list numbers
     *
     * @param data
     */
    public void setAvg(ArrayList<Double> data) {
        double data_sum = 0;
        for (int i = 0; i < data.size(); i++) {
            data_sum += data.get(i);
        }
        avg = data_sum / data.size();
    }

    /**
     * method getAvg: returns avg of array list
     *
     * @return avg
     */
    public double getAvg() {
        return avg;
    }

    /**
     * method setMinMax: finds and sets max and min of array list 'data'
     */
    public void setMinMax() {
        max = Collections.max(data);
        min = Collections.min(data);
    }

    /**
     * method getMin: gets min of array list
     *
     * @return min
     */
    public double getMin() {
        return min;
    }

    /**
     * method getMax: gets max of array list
     *
     * @return max
     */
    public double getMax() {
        return max;
    }

    /**
     * method setStdDev: calculates and sets standard deviation
     */
    public void setStdDev() {
        /* instantiate */
        avg_copy = 0;
        avgSqrdDiff = 0;
        stdDev = 0;

        stdDevData.clear();
        avg_copy = getAvg();

        for (double i : data) {
            i -= avg_copy;
            stdDevData.add(pow(i, 2));
        }

        for (double j : stdDevData) {
            avgSqrdDiff += j;
        }
        /* find variance */
        avgSqrdDiff /= stdDevData.size();
        /*find sqrt of variance aka deviation */
        stdDev = sqrt(avgSqrdDiff);
    }

    /**
     * method getStdDev: gets standard deviation of array list
     *
     * @return stdDev
     */
    public double getStdDev() {
        return stdDev;
    }
} //End Subclass ReadData
