package mfm.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	private static String[] arg = {"MFM","",null};
	public static void main(String[] args) throws IOException, InterruptedException {
		//put args[] in arg[]
		int len = args.length;
		int i = 0;
		while (i < 4) {
			if (len != i) {
				arg[i] = args[i];
				i++;
			}
			else { break; }
		}
		String min;
		if (arg[0].equals("MFMS")) { //change file location if its mfm_server
			File floc = new File("serv location.txt");
			BufferedReader br = new BufferedReader(new FileReader(floc));
			min = br.readLine();
			br.close();
		}
		else { //get .minecraft file location
			min = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Roaming\\.minecraft";
		}
		MFM.main(min, arg[0], arg[1], arg[2]);
	}
}