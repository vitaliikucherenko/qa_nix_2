package com.nixsolutions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.nixsolutions.FileRead.getStringFromFile;
import static com.nixsolutions.FileWrite.createFile;
import static com.nixsolutions.Operation.*;

public class IonioMain {
    public static void main(String[] args) throws IOException {
        System.out.println("input.txt file contains:"+"\n"+getStringFromFile()+"\n");
        System.out.println("Number of unique words:");
        String data = uniqueWords();
        System.out.println(data);
        System.out.println("Palindrome words and their number:");
        System.out.println(getStringFromFile());
        String pol =countOfPalindrome();
        System.out.println(pol);
        String s = countOfSentences();
        System.out.println(s+"\n");
        createFile();
        System.out.println("output.txt file located in the "+new File("output.txt").getAbsolutePath());
    }
}
