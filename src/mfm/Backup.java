package mfm;

import java.io.FileWriter;
import java.io.IOException;

public class Backup {

	static void main(String min) throws IOException, InterruptedException {
		String[] worlds = ClassMFM.available(min+"\\saves", false, true);
		Print.n();
		System.out.println("Type the world or | all | to do all available");
		String world = Tools.scan();
		FileWriter write7z = new FileWriter("7zBackup.bat");
		//write7z.write("color 2\n\"C:\\Program Files\\7-Zip\\7z.exe\" e \""+min+"\\logs\\*.gz\" -o\"output\\logs\\\"\nexit");
		//write7z.close();
		Tools.run7z("7zBackup.bat");
		System.out.println(world);
	}
}
