package mfm.menu;

import java.io.File;
import java.io.IOException;

import mfm.main.*;
import mfm.tools.*;

public class MFM {	
	static void main(String min, boolean serv) throws IOException, InterruptedException {
		String com = "";
		while (!com.equals("0")) {
			Print.menu(serv);
			com = Tools.scan();
			Print.bar();
			if (!serv) {
				if (com.equals("1")) {	
					Indexes.main(min, null);
				}				
				else if (com.equals("2")) {
					Objects.main(min, null);
				}
				else if (com.equals("3")) {
					Old.main(min);
				}
			}
			if (com.equals("4")) {
				new File("temp").mkdirs();
				Logs.main(min, serv);
			}
			else if (com.equals("5")) {
				Delete.main(null, serv);
			}
			else if (com.equals("6")) {
				new File("temp").mkdirs();
				Backup.main(min, serv);
			}
		System.gc();
		}
	}
}