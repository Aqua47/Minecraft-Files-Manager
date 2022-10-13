package mfm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Logs {
	static int main(String min) throws IOException, InterruptedException {
		long startTime = System.nanoTime();
		//delete logs files to replace it
		Delete.main(min, "4");
		//create 7z.bat
		FileWriter write7z = new FileWriter("7zLogs.bat");
		write7z.write("color 2\n\"C:\\Program Files\\7-Zip\\7z.exe\" e \""+min+"\\logs\\*.gz\" -o\"output\\logs\\\"\nexit");
		write7z.close();
		//.log
		
		//Path Slog = Paths.get(min+"\\logs\\latest.log");
		//Path Dlog = Paths.get("output\\logs\\latest.log");
		//Files.copy(Slog, Dlog, StandardCopyOption.REPLACE_EXISTING);
		//Slog = Paths.get(min+"\\logs\\debug.log");
		//Dlog = Paths.get("output\\logs\\debug.log");
		//Files.copy(Slog, Dlog, StandardCopyOption.REPLACE_EXISTING);
		
		//7z
		Tools.run7z("7zLogs.bat");
		
		int timeLog = 0;
		int logNb = 0;
		String log = " ";
		int repeatLog = ClassMFM.available("output\\logs",false,false).length;
		while (repeatLog != 0) {
			log = ClassMFM.available("output\\logs",false,false)[logNb];
			BufferedReader br = new BufferedReader(new FileReader("output\\logs\\"+log));
			String logLine = br.readLine();
			String firstTime = findTime(logLine);
			String lastTime = findTime(logLine);
			String lastLine = "";
			while (logLine != null) {
				if (logLine != null && findTime(logLine) != "") {
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
				System.out.println(ClassMFM.available("output\\logs",false,false)[logNb]+"  second: "+time);
			}
			logNb++;
			repeatLog--;
		}
		Print.timePlay(timeLog);
		Print.time(startTime);
		System.gc();
		return timeLog;
	}
	
	static String findTime (String line) {
		String out = "";
		int position = line.indexOf(":");
		if (position < 18 && position != -1 && line.startsWith("[")) {
			out = line.substring(position-2,position+6);
		}		
		return out;
	}
	
	static int calcTime (String time) {
		int hours = Integer.valueOf(time.substring(0,2));
		int minutes = Integer.valueOf(time.substring(3,5));
		int seconds = Integer.valueOf(time.substring(6,8));
		seconds = seconds+(minutes*60)+(hours*3600);
		return seconds;
	}
}