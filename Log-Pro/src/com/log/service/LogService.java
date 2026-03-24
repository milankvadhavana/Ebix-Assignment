package com.log.service;
import java.io.*;
import java.util.*;

public class LogService {
	public void analyzeLogs(String filePath) {
		List<String> allLines = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line =br.readLine())!= null) {
				allLines.add(line);
			}
			}catch(IOException e) {
				System.out.println("Error reading file :" + e.getMessage());
				return;
		}
		int mid = allLines.size() /2;
		List<String> part1 = allLines.subList(0, mid);
		List<String> part2 = allLines.subList(mid, allLines.size());
		
		LogProcessor t1 = new LogProcessor(part1);
        LogProcessor t2 = new LogProcessor(part2);
        
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int totalInfo = t1.getInfoCount() + t2.getInfoCount();
        int totalError = t1.getErrorCount() + t2.getErrorCount();
        int totalWarning = t1.getWarningCount() + t2.getWarningCount();
        
        System.out.println("INFO Count: " + totalInfo);
        System.out.println("ERROR Count: " + totalError);
        System.out.println("WARNING Count: " + totalWarning);
	}

}
