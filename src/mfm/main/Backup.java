package mfm.main;

import java.io.IOException;

import mfm.tools.*;

public class Backup {

	public static void main(String min, boolean serv, String world) throws IOException, InterruptedException {
		String txt = "";
		if (serv) {
			txt = "color 2\n7z a MFMS\\backup\\.7z "+min+"\nexit";
		}
		else {
			String worlda = world;
			if (world == null) {
				Tools.available(min+"\\saves", false, true);
				Print.n();
				System.out.println("Type the world or | all | to do all available");
				world = Tools.scan();
			}
			else if (world.equals("all")) {
				world = "";
				worlda = "all";
			}
			txt = "color 2\n7z a MFM\\backup\\"+worlda+".7z "+min+"\\saves\\"+world+"\nexit";
		}
		Tools.write7z("temp\\7z_Backup.bat", txt);
		Tools.run7z("temp\\7z_Backup.bat");
	}
}




