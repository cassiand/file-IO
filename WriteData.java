package cpularo_week12;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Cassian Pularo
 * @Assignment Name: cpularo_week12
 * @Date: Dec 4, 2022
 * @Subclass WriteData Description: subclass to hold methods to write data to
 * text file
 */
//Imports
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

//Begin Subclass WriteData

public class WriteData {

    static ArrayList<Double> userData;
    private File fFile;

    /* constructor */
    public WriteData() {
        userData = new ArrayList<>();
    }

    /**
     * method addNum: adds number to array list userData
     *
     * @param num
     */
    public void addNum(double num) {
        userData.add(num);
    }

    /**
     * method setUserData: writes array list's numbers into designated file
     *
     * @param file
     */
    public void setUserData(File file) {
        fFile = file;
        try ( PrintWriter output = new PrintWriter(fFile)) {
            for (double i : userData) {
                output.printf("%.4f" + System.getProperty("line.separator"), i);
            }
            output.close();
        } catch (FileNotFoundException ex) {
            System.out.println("The specified file could not be found");
        }

    }

    /**
     * method getUserData: display each array list element on its own line
     */
    public void getUserData() {
        for (int i = 0; i < userData.size(); i++) {
            System.out.println(userData.get(i));
        }
    }

    /**
     * method getArray: returns array elements
     *
     * @return userData
     */
    public ArrayList getArray() {
        return userData;
    }
} //End Subclass WriteData
