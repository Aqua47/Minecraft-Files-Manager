package mfm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class Delete {
	static boolean main(String min, String com) throws IOException {
		Print.menuDelete();
		boolean r = true;
		if (com == null) {
			com = Tools.scan();
		}
		
		if (com.equals("all")) {	
			deleteAll("output");
		}
		else if (com.equals("1")) {	
			deleteAll("output\\indexes");
		}
		else if (com.equals("2")) {
			deleteAll("output\\objects");
		}
		else if (com.equals("4")) {
			deleteAll("output\\logs");
		}
		else {
			r = false;
		}
		System.gc();
		return r;
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
	static void deleteFile(String loc) throws IOException {
		new File(loc).delete();
	}
}