package www.nixsolutions.com;

import static java.lang.Integer.parseInt;
import static www.nixsolutions.com.GetString.getNumberFromConsole;
import static www.nixsolutions.com.GetString.getStringFromConsole;
import static www.nixsolutions.com.Selection.selectionAndResult;

public class ArraysAndStringMain {

    public static void main(String[] args) {
        selectionAndResult(getStringFromConsole("please, enter your data:"), parseInt(getNumberFromConsole()));
    }
}