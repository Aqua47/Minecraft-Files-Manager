package mfm.main;

import java.io.FileWriter;
import java.io.IOException;

import mfm.tools.*;

public class Backup {

	public static void main(String min, boolean serv) throws IOException, InterruptedException {
		FileWriter write7z = new FileWriter("temp\\7z_Backup.bat");
		if (serv) {
			write7z.write("color 2\n7z a MFMS\\backup\\.7z "+min+"\nexit");
		}
		else {
			Tools.available(min+"\\saves", false, true);
			Print.n();
			System.out.println("Type the world or | all | to do all available");
			String world = Tools.scan();
			String worlda = world;
			if (world.equals("all")) {
				world = "";
				worlda = "all";
			}
			write7z.write("color 2\n7z a MFM\\backup\\"+worlda+".7z "+min+"\\saves\\"+world+"\nexit");
		}
		write7z.close();
		Tools.run7z("temp\\7z_Backup.bat");
	}
}




