package mfm.tools;

public class Print {
	public static void n() {
		System.out.println();
	}
	public static void bar() {
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	//menu
	
	public static void mmenu(boolean s) {
		Print.bar();
		if (s) {
			System.out.println("|                          manage your server files                             |");
		} else {	
			System.out.println("|                          manage your games files                             |");
		}
		Print.bar();
	}
	
	public static void menu(boolean s) {
		Print.bar();
		System.out.println("|                                                                               |");
		System.out.println("|                     Type one of the following numbers:                        |");
		System.out.println("|                                                                               |");
		Print.bar();
		if (!s) {
			System.out.println("| 1 | Indexes - Create a readable indexe (auto-created if necessary)            |");
			Print.bar();
			System.out.println("| 2 | Objects - Extract the hashed files into normal files                      |");
			Print.bar();
			System.out.println("| 3 | Old - Remove old minecraft version except version choose                  |");
			Print.bar();
		}
		System.out.println("| 4 | Logs - Show info of logs files (you need to download 7-Zip!)              |");
		Print.bar();
		System.out.println("| 5 | Delete - Remove files created by this program                             |");
		Print.bar();
		System.out.println("| 6 | Backup - Create a backup for your world (you need to download 7-Zip!)     |");	
		Print.bar();
		if (!s) {
			System.out.println("| 7 | .minecraft - Open .minecraft folder                                       |");
			Print.bar();
		} else {
			System.out.println("| 7 | Server - Open your server folder                                          |");
			Print.bar();
		}
		System.out.println("| 0 | Stop - Startn't                                                           |");
		Print.bar();
	}
	public static void help() {
		System.out.println("");
		System.out.println("Usage:[1] [2] [3]");
		System.out.println("Example1:mfm ind 1.19");
		System.out.println("Example2:mfm+s delete all");
		System.out.println("Example3:mfms logs");
		System.out.println("");
		System.out.println("command:");
		System.out.println("  1:");
		System.out.println("    mfm");
		System.out.println("    mfms");
		System.out.println("    mfm+s");
		System.out.println("  2:");
		System.out.println("    indexes");
		System.out.println("    objects");
		System.out.println("    old");
		System.out.println("    logs");
		System.out.println("    delete");
		System.out.println("    backup");
		System.out.println("    .minecraft");
		System.out.println("    stop");
		System.out.println("    help");
		System.out.println("    version");
		System.out.println("  3:");
		System.out.println("    all and others options that are displayed");
		System.out.println("");
	}
	
	
	public static void menuDelete(boolean serv) {
		System.out.println("choose files to remove");
		bar();
		if (serv) {
			System.out.println("| 4 | Logs | 6 | Backup | all | for all server files                            |");
		}
		else {
			System.out.println("| 1 | Indexes | 2 | Objects | 4 | Logs | 6 | Backup | all | for all files       |");
		}
		bar();
	}
	
	
	public static void time(float startTime) {
		float elapsedTime = ((System.nanoTime() - startTime));
		float m = (Math.round(elapsedTime/100000));
		System.out.println((m/10000)+" second");
	}
	
	
}