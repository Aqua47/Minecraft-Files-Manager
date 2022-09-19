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
import java.util.Scanner;

public class ClassMFM {
	
	public static void main(String[] args) throws IOException {
		//timer
		double allTime = 0;
		//file location
		new File("output\\indexes").mkdirs();
		File floc = new File(".minecraft file location.txt");
		BufferedReader br = new BufferedReader(new FileReader(floc));
		String min = br.readLine();
		br.close();
		String fileOut = "";
		//menu
		String com = "";
		Scanner sc = new Scanner(System.in);
		//color
		while (!com.equals("0")) {
			System.out.println();
			System.out.println(" 1 - indexes");
			System.out.println(" 2 - hex");
			System.out.println(" 3 - old");
			System.out.println(" 0 - stop");
			System.out.println();
			com = sc.nextLine();
			long startTime = System.nanoTime();
			if (com.equals("1")) {	
				//files available		
				String[] pathnamesP1 = available(min+"\\assets\\indexes");
				allTime = 0;
				//version of the indexes
				String ver = sc.nextLine();
				//indexes decoder
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
					File out = new File("output\\indexes\\"+ver);
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
						if (cd==',') {
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
				available("output\\indexes");
				String ver = sc.nextLine();
				String verjson = ver+".json";
				new File("output\\objects").mkdirs();
				String hex = "0";
				FileInputStream lec = null;
				lec = new FileInputStream("output\\indexes\\"+verjson);
				char c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0,c8=0,c9=0,c10=0,c11=0,c12=0,c13=0,c14=0,c15=0,c16=0;
				char c17=0,c18=0,c19=0,c20=0,c21=0,c22=0,c23=0,c24=0,c25=0,c26=0,c27=0,c28=0,c29=0,c30=0,c31=0,c32=0;
				char c33=0,c34=0,c35=0,c36=0,c37=0,c38=0,c39=0,c40=0,c41=0,c42=0,c43=0,c44=0,c45=0,c46=0,c47=0,c48=0;
				char c49=0,c50=0,c51=0,c52=0,c53=0,c54=0,c55=0,c56=0,c57=0,c58=0,c59=0,c60=0,c61=0,c62=0,c63=0,c64=0;
				char c65=0,c66=0,c67=0,c68=0,c69=0,c70=0,c71=0,c72=0,c73=0,c74=0,c75=0,c76=0,c77=0,c78=0,c79=0,c80=0;
				String cc=" ";
				String cc2 = " ";
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
						if (c20==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19});
						}
						else if (c21==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20});
						}
						else if (c22==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21});
						}
						else if (c23==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22});
						}
						else if (c24==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23});
						}
						else if (c25==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24});
						}
						else if (c26==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25});
						}
						else if (c27==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26});
						}
						else if (c28==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27});
						}
						else if (c29==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28});
						}
						else if (c30==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29});
						}
						else if (c31==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30});
						}
						else if (c32==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31});
						}
						else if (c33==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32});
						}
						else if (c34==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33});
						}
						else if (c35==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34});
						}
						else if (c36==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35});
						}
						else if (c37==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36});
						}
						else if (c38==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37});
						}
						else if (c39==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38});
						}
						else if (c40==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39});
						}
						else if (c41==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40});
						}
						else if (c42==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41});
						}
						else if (c43==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42});
						}
						else if (c44==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43});
						}
						else if (c45==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44});
						}
						else if (c46==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45});
						}
						else if (c47==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46});
						}
						else if (c48==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47});
						}
						else if (c49==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48});
						}
						else if (c50==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49});
						}
						else if (c51==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50});
						}
						else if (c52==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51});
						}
						else if (c53==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52});
						}
						else if (c54==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53});
						}
						else if (c55==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54});
						}
						else if (c56==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55});
						}
						else if (c57==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56});
						}
						else if (c58==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57});
						}
						else if (c59==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58});
						}
						else if (c60==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59});
						}
						else if (c61==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60});
						}
						else if (c62==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61});
						}
						else if (c63==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62});
						}
						else if (c64==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63});
						}
						else if (c65==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64});
						}
						else if (c66==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65});
						}
						else if (c67==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66});
						}
						else if (c68==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67});
						}
						else if (c69==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68});
						}
						else if (c70==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69});
						}
						else if (c71==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69,c70});
						}
						else if (c72==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69,c70,c71});
						}
						else if (c73==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69,c70,c71,c72});
						}
						else if (c74==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69,c70,c71,c72,c73});
						}
						else if (c75==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69,c70,c71,c72,c73,c74});
						}
						else if (c76==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69,c70,c71,c72,c73,c74,c75});
						}
						else if (c77==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69,c70,c71,c72,c73,c74,c75,c76});
						}
						else if (c78==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69,c70,c71,c72,c73,c74,c75,c76,c77});
						}
						else if (c79==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69,c70,c71,c72,c73,c74,c75,c76,c77,c78});
						}
						else if (c80==32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69,c70,c71,c72,c73,c74,c75,c76,c77,c78,c79});
						}
						else if (c80!=32) {
							cc = new String(new char[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,
									c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59,c60,c61,c62,c63,c64,
									c65,c66,c67,c68,c69,c70,c71,c72,c73,c74,c75,c76,c77,c78,c79,c80});
						}
						if (h==1) {
							cc2 = cc.trim();
							File nfp = new File("output\\objects\\"+verjson+"\\"+cc2);
							fileOut = "output\\objects\\"+verjson+"\\"+cc2.substring(0, cc2.length() - nfp.getName().length())+nfp.getName();					
							File nf = new File(fileOut);
							nf.mkdirs();
						}
						if (h==2) {
							h = 0;									
							br.close();					
							hex = cc.substring(0,2);										
							Path source = Paths.get(min+"\\assets\\objects\\"+hex+"\\"+cc);
							Path dest = Paths.get(fileOut);
							Files.deleteIfExists(dest);
							Files.copy(source, dest);
						}
						c1=32;c2=32;c3=32;c4=32;c5=32;c6=32;c7=32;c8=32;c9=32;c10=32;c11=32;c12=32;c13=32;c14=32;c15=32;c16=32;
						c17=32;c18=32;c19=32;c20=32;c21=32;c22=32;c23=32;c24=32;c25=32;c26=32;c27=32;c28=32;c29=32;c30=32;c31=32;c32=32;
						c33=32;c34=32;c35=32;c36=32;c37=32;c38=32;c39=32;c40=32;c41=32;c42=32;c43=32;c44=32;c45=32;c46=32;c47=32;c48=32;
						c49=32;c50=32;c51=32;c52=32;c53=32;c54=32;c55=32;c56=32;c57=32;c58=32;c59=32;c60=32;c61=32;c62=32;c63=32;c64=32;
						c65=32;c66=32;c67=32;c68=32;c69=32;c70=32;c71=32;c72=32;c73=32;c74=32;c75=32;c76=32;c77=32;c78=32;c79=32;c80=32;
					}
					if (r==34) {
						get++;
						getadd = -1;
					}		
					if (get==1) {
						getadd++;		
						c1 = ccc(getadd, c, c1, 1);
						c2 = ccc(getadd, c, c2, 2);
						c3 = ccc(getadd, c, c3, 3);
						c4 = ccc(getadd, c, c4, 4);
						c5 = ccc(getadd, c, c5, 5);
						c6 = ccc(getadd, c, c6, 6);
						c7 = ccc(getadd, c, c7, 7);
						c8 = ccc(getadd, c, c8, 8);
						c9 = ccc(getadd, c, c9, 9);
						c10 = ccc(getadd, c, c10, 10);
						c11 = ccc(getadd, c, c11, 11);
						c12 = ccc(getadd, c, c12, 12);
						c13 = ccc(getadd, c, c13, 13);
						c14 = ccc(getadd, c, c14, 14);
						c15 = ccc(getadd, c, c15, 15);
						c16 = ccc(getadd, c, c16, 16);
						c17 = ccc(getadd, c, c17, 17);
						c18 = ccc(getadd, c, c18, 18);
						c19 = ccc(getadd, c, c19, 19);
						c20 = ccc(getadd, c, c20, 20);
						c21 = ccc(getadd, c, c21, 21);
						c22 = ccc(getadd, c, c22, 22);
						c23 = ccc(getadd, c, c23, 23);
						c24 = ccc(getadd, c, c24, 24);
						c25 = ccc(getadd, c, c25, 25);
						c26 = ccc(getadd, c, c26, 26);
						c27 = ccc(getadd, c, c27, 27);
						c28 = ccc(getadd, c, c28, 28);
						c29 = ccc(getadd, c, c29, 29);
						c30 = ccc(getadd, c, c30, 30);
						c31 = ccc(getadd, c, c31, 31);
						c32 = ccc(getadd, c, c32, 32);
						c33 = ccc(getadd, c, c33, 33);
						c34 = ccc(getadd, c, c34, 34);
						c35 = ccc(getadd, c, c35, 35);
						c36 = ccc(getadd, c, c36, 36);
						c37 = ccc(getadd, c, c37, 37);
						c38 = ccc(getadd, c, c38, 38);
						c39 = ccc(getadd, c, c39, 39);
						c40 = ccc(getadd, c, c40, 40);
						c41 = ccc(getadd, c, c41, 41);
						c42 = ccc(getadd, c, c42, 42);
						c43 = ccc(getadd, c, c43, 43);
						c44 = ccc(getadd, c, c44, 44);
						c45 = ccc(getadd, c, c45, 45);
						c46 = ccc(getadd, c, c46, 46);
						c47 = ccc(getadd, c, c47, 47);
						c48 = ccc(getadd, c, c48, 48);
						c49 = ccc(getadd, c, c49, 49);
						c50 = ccc(getadd, c, c50, 50);
						c51 = ccc(getadd, c, c51, 51);
						c52 = ccc(getadd, c, c52, 52);
						c53 = ccc(getadd, c, c53, 53);
						c54 = ccc(getadd, c, c54, 54);
						c55 = ccc(getadd, c, c55, 55);
						c56 = ccc(getadd, c, c56, 56);
						c57 = ccc(getadd, c, c57, 57);
						c58 = ccc(getadd, c, c58, 58);
						c59 = ccc(getadd, c, c59, 59);
						c60 = ccc(getadd, c, c60, 60);
						c61 = ccc(getadd, c, c61, 61);
						c62 = ccc(getadd, c, c62, 62);
						c63 = ccc(getadd, c, c63, 63);
						c64 = ccc(getadd, c, c64, 64);
						c65 = ccc(getadd, c, c65, 65);
						c66 = ccc(getadd, c, c66, 66);
						c67 = ccc(getadd, c, c67, 67);
						c68 = ccc(getadd, c, c68, 68);
						c69 = ccc(getadd, c, c69, 69);
						c70 = ccc(getadd, c, c70, 70);
						c71 = ccc(getadd, c, c71, 71);
						c72 = ccc(getadd, c, c72, 72);
						c73 = ccc(getadd, c, c73, 73);
						c74 = ccc(getadd, c, c74, 74);
						c75 = ccc(getadd, c, c75, 75);
						c76 = ccc(getadd, c, c76, 76);
						c77 = ccc(getadd, c, c77, 77);
						c78 = ccc(getadd, c, c78, 78);
						c79 = ccc(getadd, c, c79, 79);
						c80 = ccc(getadd, c, c80, 80);	
					}	
				}	
				lec.close();
				double elapsedTime = ((System.nanoTime() - startTime)/10000000);
				allTime = allTime + elapsedTime;
				System.out.println(elapsedTime/100+" second");
				System.out.println();
				System.out.println(allTime/100+" second");
			}		
		//part 3
			if (com.equals("3")) {
				String keep = "1.19.2";	
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
							System.out.println(path2+"  a==-1"); 
						}
					}
				}
				//timer end
				double elapsedTime = ((System.nanoTime() - startTime)/10000000);
				allTime = allTime + elapsedTime;
				System.out.println(elapsedTime/100+" second");
			}
		}
	}
	
	static String[] available (String in) {
		System.out.println();
		System.out.println("available indexes files:");
		System.out.println();
		String[] pathnamesP1;
		File fav = new File(in);
		pathnamesP1 = fav.list();		
		for (String pathnameP1 : pathnamesP1) {
			System.out.println(pathnameP1);
		}
		System.out.println();
		System.out.println("type the version without: .json  ex: 1.19 for 1.19!");
		System.out.println("or  all to do all version available");
		System.out.println();
		return pathnamesP1;
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
		if (getadd==cx) {
			if (c=='/') {
				ct = '\\';
			}
			else {
				ct = c;
			}
		}
		return ct;		
	}
	
	
	public static final String TEXT_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
			
}