package com.nixsolutions;

import java.util.*;
import java.util.stream.Collectors;

import static com.nixsolutions.FileRead.getStringFromFile;

public class Operation {
    public static String uniqueWords() {
        StringBuilder s = new StringBuilder();
        int count;
        List l = new ArrayList<>(getList());
        HashMap<String, Integer> words = new HashMap<>();
        for (int i = 0; i < l.size(); i++) {
            count = 0;
            for (int j = i; j < l.size(); j++) {
                if (l.get(i).equals(l.get(j))) {
                    count++;
                }
            }
            if (!words.containsKey(l.get(i))) {
                words.put(String.valueOf(l.get(i)), count);
            }
        }
        Map<String, Integer> sortedItems = words.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<String, Integer> entry : sortedItems.entrySet()) {
            s.append(entry.getKey()).append("= ").append(entry.getValue()).append("\n");
        }
        return s.toString();
    }

    public static String reverseWorlds(String s) {
        s = s.replaceAll("\\W", " ");
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

    public static String countOfPalindrome() {
        StringBuilder s = new StringBuilder();
        int count;
        String words = getStringFromFile();
        words = words.replaceAll("\\W", " ");
        String reverseWords = reverseWorlds(getStringFromFile());
        String[] arrayWords = words.split(" ");
        String[] arrayReverseWords = reverseWords.split(" ");
        List listWords = new ArrayList<>();
        List listReverseWords = new ArrayList<>();
        for (String st : arrayWords) {
            listWords.add(st);
        }
        listWords.removeIf(item -> item == null || "".equals(item));
        for (String st : arrayReverseWords) {
            listReverseWords.add(st);
        }
        listReverseWords.removeIf(item -> item == null || "".equals(item));
        HashMap<String, Integer> wordsResult = new HashMap<>();
        for (int i = 0; i < listWords.size(); i++) {
            count = 0;
            for (int j = i; j < listReverseWords.size(); j++) {
                if (listWords.get(i).equals(listReverseWords.get(j))) {
                    count++;
                }
            }
            if (count > 0) {
                if (!wordsResult.containsKey(listWords.get(i))) {
                    wordsResult.put(String.valueOf(listWords.get(i)), count);
                }
            }
        }
        Map<String, Integer> sortedItems = wordsResult.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<String, Integer> entry : sortedItems.entrySet()) {
            s.append(entry.getKey()).append("= ").append(entry.getValue()).append("\n");
        }
        return s.toString();
    }

    public static String countOfSentences() {
        int count = 0;
        String result;
        String s = getStringFromFile();
        String[] temp = s.split("(!|\\?|;|:|\\.)");
        for (int i = 0; i < temp.length; i++) {
            if (!temp[i].equals("")) {
                count++;
            }
        }
        return result = ("Number of sentences = " + count);
    }

    public static List<String> getList() {
        String s = getStringFromFile();
        s = s.replaceAll("\\W", " ");
        String[] q = s.split(" ");
        List l = new ArrayList<>();
        for (String st : q) {
            l.add(st);
        }
        l.removeIf(item -> item == null || "".equals(item));
        return l;
    }
}
