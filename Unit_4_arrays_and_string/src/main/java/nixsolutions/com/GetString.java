package nixsolutions.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetString {

    public static String getStringFromConsole(String message) {
        String s = "";
        boolean success = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (!success) {
            try {
                System.out.println(message);
                s = bufferedReader.readLine();
                if (s == null || s.length() == 0 || s.trim().length() <= 0) {
                    throw new Exception();
                }//close if
                success = true;
            } //close try
            catch (Exception e) {
                success = false;
            } //close catch
        } //close while
        return s;
    }

    public static String getNumberFromConsole() {
        int number;
        String s = "";
        boolean success = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (!success) {
            try {
                System.out.println("Could you please, enter number from 0 to 3:");
                System.out.println("Where, 0 - reverse string by worlds");
                System.out.println("1 - reverse all string");
                System.out.println("2 - reverse destination string");
                System.out.println("3 - reverse string by first and last indexes");
                s = bufferedReader.readLine();
                number = Integer.parseInt(s);
                if (s.length() == 0 || s.trim().length() <= 0 || number > 3) {
                    throw new Exception();
                }//close if
                success = true;
            } //close try
            catch (Exception e) {
                success = false;
            } //close catch
        } //close while
        return s;
    }

    public static String getIndexFromConsole(String message) {
        int number;
        String s = "";
        boolean success = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (!success) {
            try {
                System.out.println(message);
                s = bufferedReader.readLine();
                number = Integer.parseInt(s);
                if (s.length() == 0 || s.trim().length() < 0) {
                    throw new Exception();
                }//close if
                success = true;
            } //close try
            catch (Exception e) {
                success = false;
            } //close catch
        } //close while
        return s;
    }

}