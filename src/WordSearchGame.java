import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearchGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String filename = null;
		WordSearch game = null;
		boolean exit = false;
		
		// C:\Users\warys\Downloads\puzzle.txt
		System.out.println("Enter a filename:");
		filename = input.nextLine();
		
		try {
			game = new WordSearch(filename);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open file " + filename);
			System.exit(0);
		}
		
		while (!exit) {
			System.out.println(game);
			
			System.out.println("Enter a word to search for:");
			String word = input.nextLine();
			
			System.out.println(game.check(word));
			
			exit = word.equals("-1");
		}
		
		System.out.println(game);
	}

}
