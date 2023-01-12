package mfm.menu;

import java.io.File;
import java.io.IOException;

import mfm.main.*;
import mfm.tools.*;

public class MFM {
	public static void main(String min, String sserv, String arg2, String arg3) throws IOException, InterruptedException {
		
		/*to do list:
		
			remove indexes file with old command
		
			patch calc of time played in logs
		
			multiple serv
		
		
			in tools:
				add printwriter
				add buffreader
		
				
			add color
		
			remake objects old indexes...
		
		*/
		boolean serv = false;
		boolean wrong = false;
		if (sserv.equals("MFMS")) {
			serv = true;
		}
		boolean br = false;
		if (Tools.nothing(arg2)) {
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
				if (install7z()) {
					new File("temp").mkdirs();
					Logs.main(min, serv);
				}
			}
			else if (arg2.matches("5|del|delete")) {
				Delete.main(arg3, serv);
			}
			else if (arg2.matches("6|backup")) {
				if (install7z()) {
					new File("temp").mkdirs();
					Backup.main(min, serv, arg3);
				}
			}
			else if (!serv && (arg2.matches("7|minecraft|.minecraft"))) {
				Runtime.getRuntime().exec("explorer.exe /select,"+min+"\\assets");
			}
			else if (serv && (arg2.matches("7|serv|server"))) {
				Runtime.getRuntime().exec("explorer.exe /select,"+min);
			}
			
			else if (arg2.matches("0|exit|stop")) {
				break;
			}
			else if (arg2.startsWith("help") || arg2.startsWith("welp")) {
				System.out.println("help is on the way!");
				Print.help();
			}
			else if (arg2.matches("ver|version")) {
				System.out.println("1.2");
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
	
	private static boolean install7z() throws IOException, InterruptedException {
		File f = new File("C:\\Program Files\\7-Zip\\7z.exe");
		boolean r = f.exists();
		if (!r) {
			System.out.println("you need 7z to use this function would you like to download it? Y for yes");
			if (Tools.scan().toLowerCase().equals("y")) { //download 7z...
				Process gz = Runtime.getRuntime().exec("cmd /C start /wait winget install 7zip.7zip");
				gz.waitFor();
				r = true;
			}
		}
		return r;
	}
}