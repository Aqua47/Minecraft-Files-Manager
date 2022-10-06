package mfm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ClassMFM {	
	public static void main(String[] args) throws IOException, InterruptedException {
		File floc = new File(".minecraft file location.txt");
		BufferedReader br = new BufferedReader(new FileReader(floc));
		String min = br.readLine();
		br.close();
		
		String com = "";	
		Scanner sc = new Scanner(System.in);
		
		while (!com.equals("0")) {
			Print.menu();
			com = sc.nextLine();
			Print.bar();
			if (com.equals("1")) {	
				Indexes.main(min, null);
			}				
			if (com.equals("2")) {
				Objects.main(min);
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
			System.gc();
		}
		sc.close();	
	}
	
	static String[] available (String in, boolean all, boolean print) {
		if (print) {
			System.out.println("Available versions:");
			System.out.println();
		}
		String[] pathnamesP1;
		File fav = new File(in);
		pathnamesP1 = fav.list();		
		for (String pathnameP1 : pathnamesP1) {
			if (print) {
				System.out.println(pathnameP1);
			}
		}
		if (print) {
			System.out.println();
			System.out.println("Type the version without: .json  ex: 1.19 for 1.19!");
			if (all) {
				System.out.println("Or  all  to do all version available");
			}
			System.out.println();
		}
		return pathnamesP1;
	}
}