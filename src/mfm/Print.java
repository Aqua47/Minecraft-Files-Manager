package mfm;

public class Print {
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
		System.out.println("| 0 | Stop - Startn't                                                           |");
		bar();
	}
	static void time(float startTime) {
		float elapsedTime = ((System.nanoTime() - startTime));
		float m = (Math.round(elapsedTime/100000));
		System.out.println((m/10000)+" second");
	}
	static void menuDelete() {
		System.out.println("choose files to remove");
		bar();
		System.out.println("| 1 | Indexes | 2 | Objects | 4 | Logs or | all | for all files in output       |");
		bar();
	}
}