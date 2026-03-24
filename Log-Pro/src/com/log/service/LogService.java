package com.log.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogService {

    public void analyzeLogs(String filePath) {

        
        List<String> lines = readFile(filePath);

        int mid = lines.size() / 2;

        List<String> part1 = lines.subList(0, mid);
        List<String> part2 = lines.subList(mid, lines.size());

        
        LogProcessor t1 = new LogProcessor(part1);
        LogProcessor t2 = new LogProcessor(part2);

        
        t1.start();
        t2.start();

        
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Thread error");
        }

        
        System.out.println("INFO Count: " + (t1.getInfoCount() + t2.getInfoCount()));
        System.out.println("ERROR Count: " + (t1.getErrorCount() + t2.getErrorCount()));
        System.out.println("WARNING Count: " + (t1.getWarningCount() + t2.getWarningCount()));
    }

    private List<String> readFile(String filePath) {

        List<String> lines = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File error: " + e.getMessage());
        }
        return lines;
    }
}