package com.nixsolutions;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.nixsolutions.FileRead.getStringFromFile;
import static com.nixsolutions.Operation.*;

public class FileWrite {
    public static void createFile() throws IOException {
        String uniqueWords = uniqueWords();
        String countOfSentences = countOfSentences();
        File file = new File("output.txt");
        FileWriter fw = new FileWriter(file, false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("input.txt file contains:"+"\n"+getStringFromFile()+"\n");
        bw.write("\n");
        bw.write("Number of unique words:"+"\n");
        bw.write(String.valueOf(uniqueWords));
        bw.write("\n");
        bw.write("Palindrome words and their number:"+"\n");
        bw.write(String.valueOf(countOfPalindrome()));
        bw.write("\n");
        bw.write(countOfSentences);
        bw.newLine();
        bw.close();
    }

}
