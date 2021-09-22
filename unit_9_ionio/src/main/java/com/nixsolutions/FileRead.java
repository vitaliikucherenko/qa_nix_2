package com.nixsolutions;

import java.io.*;

public class FileRead {
    public static String getStringFromFile() {
        StringBuilder s = new StringBuilder();
        try{
            File file = new File("input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line="";
            while(line!=null){
                line=reader.readLine();
                if (line != null && !line.isEmpty()) {
                    s.append(line);
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return s.toString();
    }
}
