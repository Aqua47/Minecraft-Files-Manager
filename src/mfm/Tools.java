package mfm;

import java.io.IOException;
import java.util.Scanner;

public class Tools {

	static String scan() {
		Scanner sc = new Scanner(System.in);
		String out = sc.nextLine();
		return out;
	}
	
	static void run7z(String in) throws InterruptedException, IOException {
		try {
			Process gz = Runtime.getRuntime().exec("cmd /C start /wait "+in);
			gz.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("you need to download 7-Zip!  7-zip.org");
		}
		Delete.deleteFile(in);
	}
	static String removeLast(String var, int remove) {
		var = var.substring(0,var.length()-remove);
		return var;
	}

}
