package mfm.main;

import java.io.IOException;

import mfm.tools.*;

public class Delete {
	public static boolean main(String com, boolean serv) throws IOException {
		Print.menuDelete(serv);
		boolean r = true;
		if (com == null) {
			com = Tools.scan();
		}
		if (com.equals("all")) {	
			if (serv) {
				Tools.deleteAll("MFMS");
			}
			else {	
				Tools.deleteAll("MFM");
			}
		}
		else if (com.equals("1")) {	
			Tools.deleteAll("MFM\\indexes");
		}
		else if (com.equals("2")) {
			Tools.deleteAll("MFM\\objects");
		}
		else if (com.equals("4")) {
			if (serv) {
				Tools.deleteAll("MFMS\\logs");
			}
			else {	
				Tools.deleteAll("MFM\\logs");
			}
		}
		else if (com.equals("6")) {
			if (serv) {
				Tools.deleteAll("MFMS\\backup");
			}
			else {	
				Tools.deleteAll("MFM\\backup");
			}
		}
		else {
			r = false;
		}
		System.gc();
		return r;
	}
}