package mfm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Scanner;

public class Delete {
	static void main(String min, String com) throws IOException {
		Print.menuDelete();
		Scanner sc = new Scanner(System.in);
		if (com == null) {
			com = sc.nextLine();
		}
		
		if (com.equals("all")) {	
			deleteAll("output");
		}
		if (com.equals("1")) {	
			deleteAll("output\\indexes");
		}
		if (com.equals("2")) {
			deleteAll("output\\objects");
		}
		if (com.equals("4")) {
			deleteAll("output\\logs");
		}
	}
	static String[] delete(String path) {
		File filepath = new File(path);
		String[] pathnames = filepath.list();
		for (String file : pathnames) {
			File fileF = new File(path+"\\"+file);
			fileF.delete();
			System.out.println(fileF);
		}
		return pathnames;
	}

	static void deleteAll(String loc) throws IOException {
		Path dir = Paths.get(loc);
		if (dir.toFile().exists()) {
			Files.walk(dir)
					.sorted(Comparator.reverseOrder())
					.forEach(path -> {
						try {
							System.out.println("Deleting: " + path);
							Files.delete(path);
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
		}
	}
}