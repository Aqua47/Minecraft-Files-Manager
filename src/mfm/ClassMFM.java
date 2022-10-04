package mfm;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ClassMFM {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String outInd = "output\\indexes\\";
		new File(outInd).mkdirs();
		File floc = new File(".minecraft file location.txt");
		BufferedReader br = new BufferedReader(new FileReader(floc));
		String min = br.readLine();
		br.close();
		String com = "";	
		String fileOut = "";
		Scanner sc = new Scanner(System.in);
		while (!com.equals("0")) {
			menu();
			com = sc.nextLine();
			long startTime = System.nanoTime();
			bar();
			if (com.equals("1")) {	
				String[] pathnamesP1 = available(min+"\\assets\\indexes",true,true);
				String ver = sc.nextLine();
				startTime = System.nanoTime();
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
					bar();
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
					timePrint(startTime);
				}
			}
			// part 2	
			if (com.equals("2")) {
				String[] pathnamesP = available(min+"\\assets\\indexes",true,true);
				if (pathnamesP.length == 0) {
					System.out.println("you need to create a readable indexe first");
				}
				String ver = sc.nextLine();
				startTime = System.nanoTime();
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
					bar();
					byte pl = 0;
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
					//%
					br = new BufferedReader(new FileReader(outInd+verjson));
					float allLine = 0;
					while (br.readLine() != null) {
						allLine++;
					}
					float line = 0;
					for (int r = 0; r!=-1;) {
						r = lec.read();
						char c = (char)r;
						if (get==2) {
							get = -2;
							h++;
							byte ccadd = 16;
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
								cc2 = cc;
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
								line++;
								if (line/allLine >= 0.25 && pl == 0) {
									System.out.print("25%   ");
									pl++;
								}
								if (line/allLine >= 0.5 && pl == 1) {
									System.out.print("50%   ");
									pl++;
								}
								if (line/allLine >= 0.75 && pl == 2) {
									System.out.print("75%   ");
									pl++;
								}
								if (line/allLine >= 1 && pl == 3) {
									System.out.println("100%");
									pl++;
								}
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
					System.out.println(verjson);
					timePrint(startTime);
				}
			}		
		//part 3
			if (com.equals("3")) {
				available(min+"\\versions",false,true);
				System.out.println("Type the version you want to keep!");
				String keep = sc.nextLine();
				startTime = System.nanoTime();
				String minName = min.substring(11,min.indexOf("A")-2);
				Runtime.getRuntime().exec("explorer.exe /select,"+"C:\\Users\\"+minName+"\\AppData\\Roaming\\.minecraft\\versions\\"+keep);
				bar();
				String keepConv = keep;
				if (keep.lastIndexOf(".") >= 3) {
					keepConv = keep.substring(0,keep.length()-2);
				}
				br = new BufferedReader(new FileReader("output\\indexes\\"+keepConv+".json"));
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
						sizeSt = sizeSt.substring(0,sizeSt.length()-1);
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
				System.out.println(bytes/1048576+" mo  "+bytes/1024+" ko  "+bytes+" o  ");
				timePrint(startTime);
			}
		//part 4	
			if (com.equals("4")) {
				startTime = System.nanoTime();
				
				//create 7z.bat
				FileWriter write7z = new FileWriter("7z.bat");
				write7z.write("color 2\n\"C:\\Program Files\\7-Zip\\7z.exe\" e \""+min+"\\logs\\*.gz\" -o\"output\\logs\\\"\nexit");
				write7z.close();
				//.log
				if (false) {
				Path Slog = Paths.get(min+"\\logs\\latest.log");
				Path Dlog = Paths.get("output\\logs\\latest.log");
				Files.copy(Slog, Dlog, StandardCopyOption.REPLACE_EXISTING);
				Slog = Paths.get(min+"\\logs\\debug.log");
				Dlog = Paths.get("output\\logs\\debug.log");
				Files.copy(Slog, Dlog, StandardCopyOption.REPLACE_EXISTING);
				}
				//7z
				File delLogs = new File("output\\logs");
				File[] filesLogs = delLogs.listFiles();
				if (filesLogs != null) {
					for (File file : filesLogs) {
						file.delete();
					}
				}
				try {
					Process gz = Runtime.getRuntime().exec("cmd /C start /wait 7z.bat");
					gz.waitFor();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("you need to download 7-Zip!  7-zip.org");
					com = "0";
				}
				//7z
				
				int timeLog = 0;
				int logNb = 0;
				String log = " ";
				int repeatLog = available("output\\logs",false,false).length;
				while (repeatLog != 0) {
					log = available("output\\logs",false,false)[logNb];
					br = new BufferedReader(new FileReader("output\\logs\\"+log));
					String logLine = br.readLine();
					String firstTime = findTime(logLine);
					String lastTime = findTime(logLine);
					String lastLine = "";
					while (logLine != null) {
						if (logLine != null && findTime(logLine) != "") {
							lastLine = logLine;
						}
						logLine = br.readLine();
					}
					if (findTime(lastTime)!=null) {
						lastTime = findTime(lastLine);
						int time = calcTime(lastTime)-calcTime(firstTime);
						if (time < 0) {
							time = time+86400;
						}
						timeLog = timeLog+time;
						System.out.println(available("output\\logs",false,false)[logNb]+"  second: "+time);
					}
					logNb++;
					repeatLog--;
				}
				System.out.println("all seconds: "+timeLog);
				int minutes = timeLog/60;
				int hours = minutes/60;
				int days = hours/24;
				System.out.println("days:"+days+" hours:"+(hours-(days*60))+" minutes:"+(minutes-(hours*60))+" seconds:"+(timeLog-(minutes*60)));				
				filesLogs = delLogs.listFiles();
				if (filesLogs != null) {
					for (File file : filesLogs) {
						file.delete();
					}
				}
				timePrint(startTime);
			}			
		}
		sc.close();	
	}
	
	static String toGZ (String str) throws IOException {
		 if (null == str || str.length() <= 0) {
	            return str;
	        }
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        GZIPOutputStream gzip = new GZIPOutputStream(out);
	        gzip.write(str.getBytes());
	        gzip.close();
	        return out.toString("ISO-8859-1");
	}
	
	static String toGZ2 (String str) throws IOException {
		 if (null == str || str.length() <= 0) {
	            return str;
	        }
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        GZIPOutputStream gzip = new GZIPOutputStream(out);
	        gzip.write(str.getBytes());
	        gzip.close();
	        return out.toString("ISO-8859-1");
	}
	
	static String gzTo (String str) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        GZIPInputStream gzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n = 0;
        while ((n = gzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        return out.toString("utf-8");
	
	}
	
	static String gzTo2 (String str) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        GZIPInputStream gzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n = 0;
        while ((n = gzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        return out.toString("utf-8");
	
	}
	
	static boolean bar () {
		System.out.println("---------------------------------------------------------------------------------");
		return true;
	}
	
	static boolean menu () {
		bar();
		System.out.println("|                                                                               |");
		System.out.println("|                     Type one of the following numbers:                        |");
		System.out.println("|                                                                               |");
		bar();
		System.out.println("| 1 | Indexes - Create a readable indexe (essential to use 2 and 3)             |");
		bar();
		System.out.println("| 2 | Extract - Extract the hashed files into normal files                      |");
		bar();
		System.out.println("| 3 | Old - Remove old minecraft version except 1.19.2                          |");
		bar();
		System.out.println("| 4 | Logs - Show info of logs files (you need to download 7-Zip!)              |");
		bar();
		System.out.println("| 0 | Stop - Startn't                                                           |");
		bar();
		return true;
	}
	
 	static boolean timePrint (float startTime) {
		float elapsedTime = ((System.nanoTime() - startTime)/10000000);
		System.out.println(elapsedTime/100000*1000+" second");
		return true;
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
	
	static String findTime (String line) {
		String out = "";
		int position = line.indexOf(":");
		if (position < 18 && position != -1 && line.startsWith("[")) {
			out = line.substring(position-2,position+6);
		}		
		return out;
	}
	
	static int calcTime (String time) {
		int hours = Integer.valueOf(time.substring(0,2));
		int minutes = Integer.valueOf(time.substring(3,5));
		int seconds = Integer.valueOf(time.substring(6,8));
		seconds = seconds+(minutes*60)+(hours*3600);
		return seconds;
	}

}