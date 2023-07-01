package cpularo_week12;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Cassian Pularo
 * @Assignment Name: cpularo_week12
 * @Date: Dec 4, 2022
 * @Subclass Validate Description: subclass to hold methods for validating user
 * entries
 */
//Imports

//Begin Subclass Validate
public class Validate {

    private final String yes;
    private final String no;
    public Boolean yesNo;
    public Boolean menuChoice;
    public Boolean checkNum;

    public Validate() {
        yes = "Y";
        no = "N";
        yesNo = false;
        menuChoice = true;
        checkNum = false;
    }

    /**
     * method checkYesNo: checks if user answer is either yes or no (y/Y or n/N)
     *
     * @param reply
     * @return Boolean yesNo
     */
    public Boolean checkYesNo(String reply) {
        this.yesNo = reply.equalsIgnoreCase(yes) || 
                (reply.equalsIgnoreCase(no));
        return yesNo;
    }

    /**
     * method checkMenu: checks if user's menu choice is within bounds
     *
     * @param choice
     * @return Boolean menuChoice
     */
    public Boolean checkMenu(int choice) {
        if (choice != 1 && choice != 2 && choice != 3) {
            this.menuChoice = false;
        }
        return menuChoice;
    }

} //End Subclass Validate
