package mfm.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tools {
	
	public static boolean nothing (String in) {
		return (in == null || in.length() == 0);
	}
	
	//add printwriter
	//add buffreader

	public static String scan() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	//substring
	
	public static String removeLast(String var, int remove) {
		var = var.substring(0,var.length()-remove);
		return var;
	}
	
	//available
	
	public static String[] available (String in, boolean all, boolean print) {
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
	
	//7z
	
	public static void write7z(String name, String txt) throws IOException{
		FileWriter write7z = new FileWriter(name);
		write7z.write(txt);
		write7z.close();
	}
	
	public static void run7z(String in) throws InterruptedException, IOException {
		try {
			Process gz = Runtime.getRuntime().exec("cmd /C start /wait "+in);
			gz.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("you need to download 7-Zip!  7-zip.org");
		}
		new File(in).delete();
		new File("temp").delete();
	}

}
