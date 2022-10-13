package mfm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ClassMFM {	
	public static void main(String[] args) throws IOException, InterruptedException {
		File floc = new File(".minecraft file location.txt");
		BufferedReader br = new BufferedReader(new FileReader(floc));
		String min = br.readLine();
		//if (br.readLine()!=null) {
			//Jframe.main(min);
		//}
		br.close();
		
		String com = "";
		
		while (!com.equals("0")) {
			Print.menu();
			com = Tools.scan();
			Print.bar();
			if (com.equals("1")) {	
				Indexes.main(min, null);
			}				
			if (com.equals("2")) {
				Objects.main(min, null);
			}
			if (com.equals("3")) {
				Old.main(min);
			}
			if (com.equals("4")) {
				Logs.main(min);
			}
			if (com.equals("5")) {
				Delete.main(min, null);
			}
			if (com.equals("6")) {
				Backup.main(min);
			}
			System.gc();
		}
	}
	
	static String[] available (String in, boolean all, boolean print) {
		if (print) {
			System.out.println("Available:");
			Print.n();
		}
		String[] pathnamesP1;
		File fav = new File(in);
		pathnamesP1 = fav.list();		
		for (String pathnameP1 : pathnamesP1) {
			if (print) {
				System.out.println(pathnameP1);
			}
		}
		if (all) {
			Print.n();
			System.out.println("Type the version without: .json  ex: 1.19 for 1.19!");	
			System.out.println("Or  all  to do all available");
			Print.n();
		}
		return pathnamesP1;
	}
}