package mfm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Logs {
	static void main(String min) throws IOException, InterruptedException {
		long startTime = System.nanoTime();
		
		//create 7z.bat
		FileWriter write7z = new FileWriter("7z.bat");
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
		File delLogs = new File("output\\logs");
		File[] filesLogs = delLogs.listFiles();
		if (filesLogs != null) {
			for (File file : filesLogs) {
				file.delete();
			}
		}
		try {
			Process gz = Runtime.getRuntime().exec("cmd /C start /wait 7z.bat");
			gz.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("you need to download 7-Zip!  7-zip.org");
			String com = "0";
		}
		//7z
		
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
		System.out.println("all seconds: "+timeLog);
		int minutes = timeLog/60;
		int hours = minutes/60;
		int days = hours/24;
		System.out.println("days:"+days+" hours:"+(hours-(days*60))+" minutes:"+(minutes-(hours*60))+" seconds:"+(timeLog-(minutes*60)));				
		filesLogs = delLogs.listFiles();
		if (filesLogs != null) {
			for (File file : filesLogs) {
				file.delete();
			}
		}
		Print.time(startTime);
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