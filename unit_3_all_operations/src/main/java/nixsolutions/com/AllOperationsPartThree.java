package nixsolutions.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AllOperationsPartThree {

    public void run() {
        int number = 0;
        int h, m;
        String s;
        boolean success = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (!success) {
            try {
                System.out.println("please, enter lesson number from 1 to 10:");
                s = bufferedReader.readLine();
                number = Integer.parseInt(s);
                if (number < 1 || number > 10) {
                    throw new Exception();
                }//close if
                success = true;
            } //close try
            catch (Exception e) {
                success = false;
            } //close catch
        } //close while
        h = number * 45 + number / 2 * 5 + (number - 1) / 2 * 15;
        m = h % 60;
        System.out.println("Lesson " + number + " will be finished at: " + (9 + (h / 60)) + ":" + m);
    }
}