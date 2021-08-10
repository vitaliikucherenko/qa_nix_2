package nixsolutions.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllOperationsPartTwo {

    public void run() {
        String s = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("please, enter your value:");
            s = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] chars = s.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "").toCharArray();
//sort
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[j] > chars[j + 1]) {
                    char tmp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = tmp;
                }
            }
        }
        char[] allReadyProcessed = new char[chars.length]; // contains processed data
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            char currentElement = chars[i];
            if (indexOf(allReadyProcessed, currentElement) >= 0) //skip processed data
            {
                continue; //return to i
            }
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count++;
                }
            }
            allReadyProcessed[i] = currentElement; // add processed data
            System.out.println("chars = " + chars[i] + " " + count + " times");
        }
    }
    //if element is added to data then return ID of element, else -1
    public static int indexOf(char[] arr, char element) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == element) {
                return j;
            }
        }
        return -1;
    }
}
