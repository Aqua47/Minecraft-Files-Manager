package mfm.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import mfm.tools.*;

public class Indexes {
	public static void main(String min, String ver) throws IOException {
		new File("MFM\\indexes\\").mkdirs();
		String[] pathnamesP1;
		if (ver == null) {
			pathnamesP1 = Tools.available(min+"\\assets\\indexes",true,true);
			ver = Tools.scan();
		} else {
			pathnamesP1 = Tools.available(min+"\\assets\\indexes",false,false);
		}
		byte a = -1;
		int p = pathnamesP1.length;
		if (ver.equals("all")) {
			a = 0;
		}
		else {
			ver = ver+".json";
			p = 0;
		}
		if (a != -1) {
			ver = (pathnamesP1[a]);
		}
		while(p != a) {
			long startTime = System.nanoTime();
			//Print.bar();
			if (a != -1) {
				ver = (pathnamesP1[a]);
			}
			a++;
			FileInputStream fin = null;
			if (new File(min+"\\assets\\indexes\\"+ver).exists()) {
				fin = new FileInputStream(min+"\\assets\\indexes\\"+ver);	
				File out = new File("MFM\\indexes\\"+ver);
				FileWriter fw = new FileWriter(out);
				PrintWriter pw = new PrintWriter(fw);
				char cd;
				byte vir = 0;
				if (ver.equals("pre-1.6.json")) {
					vir = -1;
				}					
				//indexes decoder loop
				int ci;
				for (ci = fin.read(); ci!=-1; ci = fin.read()) {
					cd = (char)ci;
					pw.print(cd);
					if (cd == ',') {
						vir++;
						if (vir==2) {
							vir = 0;
							pw.println();
						}
					}
				}
				fw.close();
				fin.close();
				System.out.println("indexes "+ver+" created");
			}
			Print.time(startTime);
		}
		System.gc();
	}
}