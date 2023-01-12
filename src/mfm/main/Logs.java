package mfm.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import mfm.tools.*;

public class Logs {
	public static void main(String min, boolean serv) throws IOException, InterruptedException {
		long startTime = System.nanoTime();
		String mfm = "";
		if (serv == false) {
			mfm = "MFM";
		}
		else {
			mfm = "MFMS";
		}
		//delete logs files to replace it
		Delete.main("4", serv);
		//create 7z.bat
		Tools.write7z("temp\\7z_Logs.bat", "color 2\n\"C:\\Program Files\\7-Zip\\7z.exe\" e \""+min+"\\logs\\*.gz\" -o\""+mfm+"\\logs\"\nexit");
		Tools.run7z("temp\\7z_Logs.bat");
		
		int timeLog = 0;
		int logNb = 0;
		String log = " ";
		String[] logs = Tools.available(mfm+"\\logs",false,false);
		int repeatLog = logs.length;
		while (repeatLog != 0) {
			log = logs[logNb];
			BufferedReader br = new BufferedReader(new FileReader(mfm+"\\logs\\"+log));
			String logLine = br.readLine();
			String firstTime = findTime(logLine);
			String lastTime = findTime(logLine);
			String lastLine = "";
			while (logLine != null) {
				if (findTime(logLine) != "") {
					lastLine = logLine;
				}
				logLine = br.readLine();
			}
			if (findTime(lastTime)!=null) {
				lastTime = findTime(lastLine);
				int time = calcTime(lastTime)-calcTime(firstTime);
				if (time < 0) {
					time = time+86400;
				}
				timeLog = timeLog+time;
				System.out.println(logs[logNb]+"  second: "+time);
			}
			logNb++;
			repeatLog--;
		}
		timePlay(timeLog);
		Print.time(startTime);
	}
	
	private static String findTime (String line) {
		String out = "";
		int position = line.indexOf(":");
		if (position < 18 && position != -1 && line.startsWith("[")) {
			out = line.substring(position-2,position+6);
		}		
		return out;
	}
	
	private static int calcTime (String time) {
		int hours = Integer.valueOf(time.substring(0,2));
		int minutes = Integer.valueOf(time.substring(3,5));
		int seconds = Integer.valueOf(time.substring(6,8));
		seconds = seconds+(minutes*60)+(hours*3600);
		return seconds;
	}
	
	private static void timePlay(int timeLog) {
		System.out.println("all seconds: "+timeLog);
		int minutes = timeLog/60;
		int hours = minutes/60;
		int days = hours/24;
		System.out.println("days:"+days+" hours:"+(hours-(days*60))+" minutes:"+(minutes-(hours*60))+" seconds:"+(timeLog-(minutes*60)));
	}
}