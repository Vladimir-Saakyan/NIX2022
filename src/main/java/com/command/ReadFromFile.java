package com.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFromFile implements Command {

    private static final Pattern PATTERN = Pattern.compile("[\\d-:, ]+([A-Z]*).+");
    @Override
    public void execute() {
        final File file = new File("logs/log.txt");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line= bufferedReader.readLine())!=null) {

                Matcher matcher = PATTERN.matcher(line);
                if(matcher.find()){
                    System.out.println("log level: " + matcher.group(1));
                }
                line = bufferedReader.readLine();
            }


        }catch (final IOException e){
            e.printStackTrace();
        }
    }
}
