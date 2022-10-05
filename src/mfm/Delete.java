package mfm;

import java.io.File;
import java.util.Scanner;

public class Delete {
	static void main(String min, String com) {	
		System.out.println("in progress");
		Print.menuDelete();
		Scanner sc = new Scanner(System.in);
		if (com == null) {
			com = sc.nextLine();
		}
		
		if (com.equals("1") || com.equals("all")) {	
			delete("output\\indexes\\");
		}				
		if (com.equals("2") || com.equals("all")) {
			System.out.println("in progress");
		}
		if (com.equals("4") || com.equals("all")) {
			delete("output\\logs\\");
		}
	}
	static void delete(String path) {
		File filepath = new File(path);
		
	}
}