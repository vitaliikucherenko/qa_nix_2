package nixsolutions.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllOperationsPartOne {

    public void run() {
        String s = "";
        int sum = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("please, enter your value:");
            s = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (char c : s.replaceAll("\\D", "").toCharArray()) {
            int number = Integer.parseInt(c + "");
            sum += number;
        }
        System.out.println(sum);
    }
}
