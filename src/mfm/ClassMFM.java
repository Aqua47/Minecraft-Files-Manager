package mfm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassMFM {
	
	public static void main(String[] args) throws IOException {
		double allTime = 0;
		String outInd = "output\\indexes\\";
		new File(outInd).mkdirs();
		File floc = new File(".minecraft file location.txt");
		BufferedReader br = new BufferedReader(new FileReader(floc));
		String min = br.readLine();
		br.close();
		String fileOut = "";
		String com = "";
		Scanner sc = new Scanner(System.in);
		while (!com.equals("0")) {
			menu();
			com = sc.nextLine();
			long startTime = System.nanoTime();
			if (com.equals("1")) {	
				String[] pathnamesP1 = available(min+"\\assets\\indexes");
				allTime = 0;
				String ver = sc.nextLine();
				System.out.println("---------------------------------------------------------------------------------");
				int a = -1;
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
					if (a != -1) {
						ver = (pathnamesP1[a]);
					}
					a++;
					FileInputStream fin = null;
					fin = new FileInputStream(min+"\\assets\\indexes\\"+ver);			
					File out = new File(outInd+ver);
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
					System.out.println("indexes "+ver+" created");
					fin.close();
					pw.close();
				}
			}
			// part 2	
			if (com.equals("2")) {
				String[] pathnamesP = available(min+"\\assets\\indexes");
				if (pathnamesP.length == 0) {
					System.out.println("you need to create a readable indexe first");
				}
				String ver = sc.nextLine();	
				System.out.println("---------------------------------------------------------------------------------");
				String verjson = ver+".json";
				int a = -1;
				int p = pathnamesP.length;
				if (ver.equals("all")) {
					a = 0;
				}
				else {
					p = 0;
				}
				if (a != -1) {
					verjson = (pathnamesP[a]);
					ver = verjson.substring(0,verjson.length()-4);
				}
				while(p != a) {
					if (a != -1) {
						verjson = (pathnamesP[a]);
						ver = verjson.substring(0,verjson.length()-4);
					}
					a++;
					new File("output\\objects").mkdirs();
					String hex = "0";
					FileInputStream lec = null;
					lec = new FileInputStream(outInd+verjson);
					List<Character> ca = new ArrayList<Character> ();
					for (short ca80 = 0; ca80 !=80; ca80++) {
						ca.add(' ');
					}
					String cc="";
					String cc2 = "";
					byte get = -2;
					if (verjson.equals("pre-1.6.json")) {
						get = -4;
					}
					byte getadd = -1;
					byte h = 0;
					for (int r = 0; r!=-1;) {
						r = lec.read();
						char c = (char)r;
						if (get==2) {
							get = -2;
							h++;
							byte ccadd = 20;
							byte lim = 0;
							while (ccadd != 80) {
								if (lim != 1 || ca.get(ccadd).equals(' ')) {
									cc = cc(ca, ccadd);	
									cc = cc.trim();
									lim++;
								}
								lim = 0;
								ccadd++;							
							}
							if (h==1) {
								cc2 = cc.trim();
								File nfp = new File("output\\objects\\"+ver+"\\"+cc2);
								fileOut = "output\\objects\\"+ver+"\\"+cc2.substring(0, cc2.length() - nfp.getName().length())+nfp.getName();
								File nf = new File(fileOut);
								nf.mkdirs();
							}
							if (h==2) {
								h = 0;			
								hex = cc.substring(0,2);
								Path source = Paths.get(min+"\\assets\\objects\\"+hex+"\\"+cc);
								Path dest = Paths.get(fileOut);
								Files.deleteIfExists(dest);
								Files.copy(source, dest);
							}
							for (byte ca80 = 0; ca80 != 80; ca80++) {
								ca.set(ca80,' ');
							}
						}
						if (r==34) {
							get++;
							getadd = -1;
						}		
						if (get==1) {
							getadd++;
							for (byte caplus = 0; caplus != 80; caplus++) {
								ca.set(caplus,ccc(getadd, c, ca.get(caplus), caplus));
							}
						}
					}
					lec.close();
					double elapsedTime = ((System.nanoTime() - startTime)/10000000);
					allTime = allTime + elapsedTime;
					//System.out.println(elapsedTime/100+" second");
					System.out.println(verjson);
					//System.out.println(allTime/100+" second");
				}
			}		
		//part 3
			if (com.equals("3")) {
				available(min+"\\versions");
				System.out.println("Type the version you want to keep!");
				String keep = sc.nextLine();
				System.out.println("---------------------------------------------------------------------------------");
				String pk = "";
				//timer	
				startTime = System.nanoTime();
				//while
				int l = path(min, "\\versions\\", keep).length-1;
				while (l != 0) {
					l = path(min, "\\versions\\", keep).length-2;
					pk = path(min, "\\versions\\", keep)[l];
					path(min, "\\versions\\"+pk, keep);
				}	
				//hex...	
				br = new BufferedReader(new FileReader("output\\indexes\\1.19.json"));
				String line = "0";
				ArrayList<String> lines = new ArrayList<String>();
				ArrayList<String> folders = new ArrayList<String>();
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
				}
				br.close();	
				String[] pathnames = {"0"};
				File file = new File(min+"\\assets\\objects");
				pathnames = file.list();
				for (String pathname : pathnames) {		
					String[] pathnames2 = {"0"};
					File file2 = new File(min+"\\assets\\objects\\"+pathname);
					pathnames2 = file2.list();
					for (String pathname2 : pathnames2) {
						File path2 = new File(file2+"\\"+pathname2);
						int a1 = lines.indexOf(pathname2);
						if (a1 == -1) {
							path2.delete();
							System.out.println(path2+"  deleted"); 
						}
					}
				}
				//timer end
				double elapsedTime = ((System.nanoTime() - startTime)/10000000);
				allTime = allTime + elapsedTime;
				System.out.println(elapsedTime/100+" second");
			}
		}
		sc.close();	
	}
	
	static boolean menu () {
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("|                                                                               |");
		System.out.println("|                     Type one of the following numbers:                        |");
		System.out.println("|                                                                               |");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("| 1 | Indexes - Create a readable indexe (essential to use all others options)  |");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("| 2 | Extract - Extract the hashed files into normal files                      |");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("| 3 | Old - Remove old minecraft version except 1.19.2                          |");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("| 0 | Stop - Startn't                                                           |");
		System.out.println("---------------------------------------------------------------------------------");
		return true;
	}
	
	static String[] available (String in) {
		System.out.println();
		System.out.println("Available versions:");
		System.out.println();
		String[] pathnamesP1;
		File fav = new File(in);
		pathnamesP1 = fav.list();		
		for (String pathnameP1 : pathnamesP1) {
			System.out.println(pathnameP1);
		}
		System.out.println();
		System.out.println("Type the version without: .json  ex: 1.19 for 1.19!");
		System.out.println("Or  all  to do all version available");
		System.out.println();
		return pathnamesP1;
	}
	
	static String cc (List <Character> ca, int c) {
		String cc = "";
		for (byte cadd = 0; cadd != c; cadd++) {
			cc += ca.get(cadd);
		}
		return cc;
	}
	
	static String[] path (String loc, String file, String keep) {
		String[] pathnames = {"0"};
	    File ver = new File(loc+file);
	    pathnames = ver.list();
	    for (String pathname : pathnames) {
	    	File path = new File(ver+"\\"+pathname);
	    	if (pathname.equals(keep) || pathname.equals(keep+".json") || pathname.equals(keep+".jar")) {}
	    	else { 
	    		path.delete();
		   		System.out.println(path);		
		   	}
	    }    
		return pathnames;
	}

	static char ccc (byte getadd, char c, char ct, int cx) {
		if (getadd==cx+1) {
			if (c=='/') {
				ct = '\\';
			}
			else {
				ct = c;
			}
		}
		return ct;		
	}

}