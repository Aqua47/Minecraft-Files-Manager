package mfm.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import mfm.tools.*;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		File floc = new File("files location.txt");
		BufferedReader br = new BufferedReader(new FileReader(floc));
		String min = br.readLine();
		String serv = br.readLine();
		if (br.readLine()!=null) {
			//Jframe.main(min);
		}
		br.close();
		Print.mmenu();
		String coms = Tools.scan();
		if (coms.equals("1")) {
			MFM.main(min, false);
		}
		else if (coms.equals("2")) {
			MFM.main(serv, true);
		}
	}

}
