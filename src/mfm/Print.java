package mfm;

public class Print {
	static void n() {
		System.out.println();
	}
	static void bar() {
		System.out.println("---------------------------------------------------------------------------------");
	}
	static void menu() {
		bar();
		System.out.println("|                                                                               |");
		System.out.println("|                     Type one of the following numbers:                        |");
		System.out.println("|                                                                               |");
		bar();
		System.out.println("| 1 | Indexes - Create a readable indexe (auto-created if necessary)            |");
		bar();
		System.out.println("| 2 | Objects - Extract the hashed files into normal files                      |");
		bar();
		System.out.println("| 3 | Old - Remove old minecraft version except version choose                  |");
		bar();
		System.out.println("| 4 | Logs - Show info of logs files (you need to download 7-Zip!)              |");
		bar();
		System.out.println("| 5 | Delete - Remove files created by this program                             |");
		bar();
		//System.out.println("| 6 | Backup - Create a backup for your world (you need to download 7-Zip!)     |");
		//bar();
		System.out.println("| 0 | Stop - Startn't                                                           |");
		bar();
	}
	static void menuDelete() {
		System.out.println("choose files to remove");
		bar();
		System.out.println("| 1 | Indexes | 2 | Objects | 4 | Logs  | all | for all files in output         |");
		bar();
	}
	static void time(float startTime) {
		float elapsedTime = ((System.nanoTime() - startTime));
		float m = (Math.round(elapsedTime/100000));
		System.out.println((m/10000)+" second");
	}
	static void timePlay(int timeLog) {
		System.out.println("all seconds: "+timeLog);
		int minutes = timeLog/60;
		int hours = minutes/60;
		int days = hours/24;
		System.out.println("days:"+days+" hours:"+(hours-(days*60))+" minutes:"+(minutes-(hours*60))+" seconds:"+(timeLog-(minutes*60)));
	}
	static void size(long bytes) {
		System.out.println(bytes/1048576+" mo  "+bytes/1024+" ko  "+bytes+" o  ");
	}
}