package mfm.main;

import java.io.IOException;

import mfm.tools.Tools;

public class Backup {

	public static void main(String min, boolean serv, String world) throws IOException, InterruptedException {
		String txt = "";
		if (serv) {
			txt = "color 2\n7z a MFMS\\backup\\.7z "+min+"\nexit";
		}
		else {
			if (world == null || world.length() == 0) {
				Tools.available(min+"\\saves", false, true);
				System.out.println();
				System.out.println("Type the world or | all | to do all available");
				world = Tools.scan();
			}
			if (world.matches("all|a")) {
				world = "";
			}
			txt = "color 2\n7z a MFM\\backup\\"+world+".7z "+min+"\\saves\\"+world+"\nexit";
			System.out.println(txt);
		}
		if (world != "0") {
			Tools.write7z("temp\\7z_Backup.bat", txt);
			Tools.run7z("temp\\7z_Backup.bat");
		}
	}
}




