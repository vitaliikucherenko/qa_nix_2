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
 /*       for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) { //charAt возвращает значение char по указанному индексу
                sum = sum + Integer.parseInt(s.charAt(i) + "");
            }
        }*/
        for (char c : s.replaceAll("\\D", "").toCharArray()) {
            int number = Integer.parseInt(c + "");
            sum += number;
        }
        System.out.println(sum);
    }
}
