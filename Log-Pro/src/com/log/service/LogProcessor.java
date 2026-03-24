package com.log.service;
import java.util.List;

public class LogProcessor extends Thread {
	private List<String> logs;
	private int infoCount =0;
	private int errorCount = 0;
	private int warningCount = 0;
	
	public LogProcessor(List<String> logs) {
		this.logs = logs;
	}
	
	@Override
	public void run() {
		for(String line : logs) {
			if(line.contains("INFO")) {
				infoCount++;
			}else if(line.contains("ERROR")) {
				errorCount++;
			}else if(line.contains("WARNING")) {
				warningCount++;
			}
		}
	}
	public int getInfoCount() {
		return infoCount;
	}
	public int getErrorCount() {
		return errorCount;
	}
	public int getWarningCount() {
		return warningCount;
	}
	
}
