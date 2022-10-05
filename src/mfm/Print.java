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
	}
	static void time(float startTime) {
		float elapsedTime = ((System.nanoTime() - startTime));
		float m = (Math.round(elapsedTime/100000));
		System.out.println((m/10000)+" second");
	}
}