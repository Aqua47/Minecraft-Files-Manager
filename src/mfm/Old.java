package mfm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Old {
	static void main(String min) throws IOException {
		ClassMFM.available(min+"\\versions",false,true);
		System.out.println("Type the version you want to keep!");
		String keep = Tools.scan();
		long startTime = System.nanoTime();
		String minName = min.substring(11,min.indexOf("A")-2);
		Runtime.getRuntime().exec("explorer.exe /select,"+"C:\\Users\\"+minName+"\\AppData\\Roaming\\.minecraft\\versions\\"+keep);
		if (keep.lastIndexOf(".") >= 3) {
			keep = Tools.removeLast(keep,2);
		}
		Path indexe = Paths.get("output\\indexes\\"+keep+".json");
		if (!Files.exists(indexe)) {
			Indexes.main(min, keep);
		}
		Print.bar();
		BufferedReader br = new BufferedReader(new FileReader("output\\indexes\\"+keep+".json"));
		String line = "0";
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<String> folders = new ArrayList<String>();
		ArrayList<String> sizeS = new ArrayList<String>();
		boolean line1 = true;
		int start = 0;
		while ((line = br.readLine()) != null) {
			if (line1 == false) {
				start = line.indexOf("{")+10;
			}
			if (line1 == true) {
				start = line.indexOf("{")+47;
				line1 = false;
			}
			lines.add(line.substring(start,start+40));
			folders.add(line.substring(start,start+2));
			String sizeSt = line.substring(start+50,line.length()-2);
			if (sizeSt.endsWith("}")) {
				sizeSt = Tools.removeLast(sizeSt,1);
			}
			sizeS.add(sizeSt);
		}
		br.close();	
		String[] pathnames = {"0"};
		File file = new File(min+"\\assets\\objects");
		pathnames = file.list();
		long bytes = 0;
		for (String pathname : pathnames) {		
			String[] pathnames2 = {"0"};
			File file2 = new File(min+"\\assets\\objects\\"+pathname);
			pathnames2 = file2.list();
			for (String pathname2 : pathnames2) {
				File path2 = new File(file2+"\\"+pathname2);
				int a1 = lines.indexOf(pathname2);
				if (a1 == -1) {
					Path path = Paths.get(file2+"\\"+pathname2);
					try {
						bytes += Files.size(path);
					} catch (IOException e) {
						e.printStackTrace();
					}
					path2.delete();
					System.out.println(path2+"  deleted"); 
				}
			}
		}
		if (false) {
		File fileI = new File(min+"\\assets\\indexes\\");
		String[] pathnamesI = fileI.list();
		for (String pathnameI : pathnamesI) {
			File path2 = new File(fileI+"\\"+pathnameI);
			int a1 = lines.indexOf(pathnameI);
			if (a1 == -1) {
				Path path = Paths.get(fileI+"\\"+pathnameI);
				try {
					bytes += Files.size(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
				path2.delete();
				System.out.println(path2+"  deleted"); 
			}
		}
		}
		System.gc();
		Print.size(bytes);
		Print.time(startTime);
	}
}