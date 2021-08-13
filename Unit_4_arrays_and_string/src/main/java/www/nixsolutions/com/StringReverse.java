package www.nixsolutions.com;

public class StringReverse {

    public static String reverseWorlds(String s) {
        String[] words = s.split(" ");
        String reversedString = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverseWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            reversedString = reversedString + reverseWord + " ";
        }
        return reversedString;
    }

    public static String reverseAll(String allString) {
        char[] res = allString.toCharArray();
        String resultString = "";
        for (int i = res.length - 1; i >= 0; i--) {
            resultString += res[i];
        }
        return resultString;
    }

    public static String reverseDestination(String strString, String dest) {
        char[] res = dest.toCharArray();
        String resultString = "";
        String tempString = "";
        for (int i = res.length - 1; i >= 0; i--) {
            tempString += res[i];
        }
        resultString = strString.replace(dest, tempString);
        return resultString;
    }

    public static String reverseByIndex(String stString, int firstIndex, int lastIndex) {
        String temp = stString.substring(firstIndex, lastIndex + 1);
        String[] words = temp.split(" ");
        String reversedString = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverseWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            reversedString = reversedString + reverseWord + " ";
        }
        reversedString = reversedString.substring(0, reversedString.length() - 1);
        String resultString = stString.replace(temp, reversedString);
        return resultString;
    }
}