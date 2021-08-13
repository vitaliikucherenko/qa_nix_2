package nixsolutions.com;

import static java.lang.Integer.parseInt;
import static nixsolutions.com.GetString.getIndexFromConsole;
import static nixsolutions.com.GetString.getStringFromConsole;
import static nixsolutions.com.StringReverse.*;

public class Selection {

    public static void selectionAndResult(String s, int n) {
        switch (n) {
            case 0:
                System.out.println("Reverse of all worlds operation is chosen");
                System.out.println("Your data was reversed: " + reverseWorlds(s));
                break;
            case 1:
                System.out.println("Reverse of all string operation is chosen");
                System.out.println("Your data was reversed: " + reverseAll(s));
                break;
            case 2:
                System.out.println("Reverse of destination string operation is chosen");
                String destEnter = getStringFromConsole("please, enter your destination:");
                System.out.println("Your data was reversed: " + reverseDestination(s, destEnter));
                break;
            case 3:
                System.out.println("Reverse string by indexes is chosen");
                String fIndex = getIndexFromConsole("Please enter the first index from 0 to " + s.length() + ":");
                int firstIndex;
                if (parseInt(fIndex) > s.length()) {
                    fIndex = getIndexFromConsole("Index should be from 0 to " + s.length() + ". Please enter the first index:");
                }
                firstIndex = parseInt(fIndex);
                String lIndex = getIndexFromConsole("Please enter the last index from " + firstIndex + " to " + s.length() + ":");
                int lastIndex;
                if (parseInt(lIndex) > s.length() || parseInt(lIndex) < parseInt(fIndex)) {
                    fIndex = getIndexFromConsole("Index should be from " + firstIndex + " to " + s.length() + ". Please enter the first index:");
                }
                lastIndex = parseInt(lIndex);
                System.out.println("Your data was reversed: " + reverseByIndex(s, firstIndex, lastIndex));
                break;
            default:
                System.out.println("You haven't selected anything.");
                break;
        }
    }
}