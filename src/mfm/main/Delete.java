package mfm.main;

import java.io.IOException;

import mfm.tools.*;

public class Delete {
	public static void main(String com, boolean serv) throws IOException {
		
		//if it's for server; change the value
		
		String mfms = "MFM";
		if (serv) {
			mfms = "MFMS";
		}
		
		//if no command enter a command
		
		if (com == null) {
			Print.menuDelete(serv);
			com = Tools.scan().toLowerCase();
		}
		
		//command execution
		
		if (com.equals("all")) {	
			Tools.deleteAll(mfms,null);
		}
		else if (com.matches("1|ind|indexe|indexes")) {	
			Tools.deleteAll("MFM\\indexes",null);
		}
		else if (com.matches("2|obj|object|objects")) {
			Tools.deleteAll("MFM\\objects",null);
		}
		else if (com.matches("4|logs")) {
			Tools.deleteAll(mfms+"\\logs",null);
		}
		else if (com.matches("6|backup")) {
			Tools.deleteAll(mfms+"\\backup",null);
		}
		else {
			System.out.println("not a valid command! Type (mfm help) for help!");
		}
	}
}