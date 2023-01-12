package mfm.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import mfm.tools.*;

public class Delete {
	public static void main(String com, boolean serv) throws IOException {
		
		//if it's for server; change the value
		
		String mfms = "MFM";
		if (serv) {
			mfms = "MFMS";
		}
		
		//if no command enter a command
		
		if (Tools.nothing(com)) {
			Print.menuDelete(serv);
			com = Tools.scan().toLowerCase();
		}
		
		if (com != "0") {
		
		//command execution
		
			if (com.matches("all|a")) {	
				deleteAll(mfms,null);
			}
			else if (com.matches("1|ind|indexe|indexes")) {	
				Tools.available(mfms+"\\indexes", false, true);
				String scan = Tools.scan();
				if (scan.matches("a|all")) {
					deleteAll(mfms+"\\indexes",null);
				} else {
					deleteAll(mfms+"\\indexes\\"+scan,null);
				}
			}
			else if (com.matches("2|obj|object|objects")) {
				Tools.available(mfms+"\\objects", false, true);
				String scan = Tools.scan();
				if (scan.matches("a|all")) {
					deleteAll(mfms+"\\objects",null);
				} else {
					deleteAll(mfms+"\\objects\\"+scan,null);
				}
			}
			else if (com.matches("4|logs")) {
				deleteAll(mfms+"\\logs",null);
			}
			else if (com.matches("6|backup")) {
				Tools.available(mfms+"\\backup", false, true);
				String scan = Tools.scan();
				if (scan.matches("a|all")) {
					deleteAll(mfms+"\\backup",null);
				} else {
					if (!scan.endsWith(".7z")) {
						scan = scan+".7z";
					}
					deleteFile(mfms+"\\backup\\"+scan);
				}
			}
			else {
				System.out.println("not a valid command! Type (mfm help) for help!");
			}
		}
	}
	
	private static void deleteAll(String loc, String notThisOne) throws IOException {
		Path dir = Paths.get(loc);
		if (dir.toFile().exists()) {
			Files.walk(dir)
					.sorted(Comparator.reverseOrder())
					.forEach(path -> {
						if (notThisOne != path.toString()) {	//check if path is complet so it works
							try {
								System.out.println("Deleting: " + path);
								Files.delete(path);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					});
		}
	}
	
	private static void deleteFile(String loc) throws IOException {
		new File(loc).delete();
	}
}