package mfm.menu;

import java.io.File;
import java.io.IOException;

import mfm.main.*;
import mfm.tools.*;

public class MFM {	
	static void main(String min, String sserv, String arg2, String arg3) throws IOException, InterruptedException {
		
		//to do list:
			//change menu print for new command and help
		
			//add version command
			//type 0 to quit everywhere...
			//delete individual backup and version(1,2)
		
			//in tools:
				//add printwriter
				//add buffreader
		
			//check old print code
		
		
		
			//remove indexes file with old command
		
		
			//add color
		
		boolean serv = false;
		boolean wrong = false;
		if (sserv.equals("MFMS")) {
			serv = true;
		}
		boolean br = false;
		if (arg2.length() == 0) {
			Print.mmenu(serv);
			Print.menu(serv);
		}
		else {
			br = true;
		}
		while (true) {
			if (!br) {
				arg2 = Tools.scan().toLowerCase();
			}
			arg2 = arg2.toLowerCase();
			Print.bar();
			if (!serv) {
				if (arg2.matches("1|ind|indexe|indexes")) {
					Indexes.main(min, arg3);
				}				
				else if (arg2.matches("2|obj|object|objects")) {
					Objects.main(min, arg3);
				}
				else if (arg2.matches("3|old")) {
					Old.main(min, arg3);
				}
			} 
			else {
				wrong = true;
			}
			if (arg2.matches("4|logs")) {
				new File("temp").mkdirs();
				Logs.main(min, serv);
			}
			else if (arg2.matches("5|del|delete")) {
				Delete.main(arg3, serv);
			}
			else if (arg2.matches("6|backup")) {
				new File("temp").mkdirs();
				Backup.main(min, serv, arg3);
			}
			else if (arg2.matches("0|exit|stop")) {
				break;
			}
			else if (arg2.startsWith("help") || arg2.startsWith("welp")) {
				System.out.println("help is on the way!");
				Print.help();
			}
			else if (wrong) {
				System.out.println("not a valid command! Type (mfm help) for help!");
			}
			if (br) {
				break;
			}
			Print.menu(serv);
			
			//clean memory
			
			System.gc();
		}
	}
}