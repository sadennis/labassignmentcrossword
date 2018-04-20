import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {
	private char [][] puzzle;
	private final int NR_ROWS;
	private final int NR_COLS;
	
	public WordSearch(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner fileInput = null;
		
		fileInput = new Scanner(file);
		
		NR_ROWS = fileInput.nextInt();
		NR_COLS = NR_ROWS;
		
		puzzle = new char[NR_ROWS][NR_COLS];
		
		for (int row = 0; row < NR_ROWS; row++) {
			for (int col = 0; col < NR_COLS; col++) {
				puzzle[row][col] = fileInput.next().charAt(0);
			}
		}
	}
	
	public boolean check(String word) {
		boolean found = false;
		
		for (int row = 0; row < NR_ROWS; row++) {
			for (int col = 0; col < NR_COLS; col++ ) {
				if (checkRight(row, col, word)) {
				System.out.println("Word found at " + row + ", " + col +" Direction: right");
				found = true;
				}
				
				
				if (checkLeft(row, col, word)) {
					System.out.println("Word found at " + row + ", " + col +" Direction: left");
					found = true;
				}
				
				if (checkUp(row, col, word)) {
					System.out.println("Word found at " + row + ", " + col +" Direction: up");
					found = true;
				}
				
				if (checkDown(row,col,word)) {
					System.out.println("Word found at " + row + ", " + col + " Direction: down");
				}
				
				if (checkLowerLeft(row, col, word)) {
					System.out.println("Word found at " + row + ", " + col + " Direction: lowerleft");
				}
			}
		}
		return found;
	}
	
	private boolean checkRight(int startRow,
			int startCol, String word) {
		boolean contains = true;
		
		contains = startCol + word.length() <= NR_COLS;
		
		for (int col = startCol; col - startCol < word.length() && col < NR_COLS && contains; col++) {
			if (puzzle[startRow][col] != word.charAt(col - startCol)) {
				contains = false;
			}
		}
		
		return contains;
	}
	
	private boolean checkLeft(int startRow, int startCol, String word) {
		boolean contains = true;
		
		contains = (startCol - (word.length() - 1)) >= 0;
		
		for (int col = startCol; col >= 0 && startCol - col < word.length() && contains; col--) {
			if (puzzle[startRow][col] != word.charAt(startCol - col)) {
				contains = false;
			}
		}
		return contains;
	}
	
	private boolean checkUp(int startRow, int startCol, String word ) {
		boolean contains = true;
		
		contains = (startRow - (word.length() - 1)) >=0;
		
		for (int row = startRow; row >= 0 && startRow - row < word.length() && contains; row--) {
			if (puzzle[row][startCol] != word.charAt(startRow - row)) {
				contains = false;
			}
		}
		return contains;
	}
	
	private boolean checkDown(int startRow, int startCol, String word) {
		boolean contains = true;
		
		contains = startRow + word.length() <= NR_ROWS;
		
		for (int row = startRow; row - startRow < word.length() && row < NR_ROWS && contains; row++) {
			if (puzzle[row][startCol] != word.charAt(row - startRow)) {
				contains = false;
			}
		}
		return contains;
	}
	
	private boolean checkLowerLeft (int startRow, int startCol, String word) {
		boolean contains = true;
		
		contains = (startCol - (word.length() - 1)) >= 0 && startRow + word.length() <= NR_ROWS;
		
		for (int row = startRow, col = startCol; row <= NR_ROWS && col >= 0; row++, col--) {
			if(puzzle[row][col] != word.charAt(col - row)){
				contains = false;
			}
		}
		
		return contains;
	}
	
	public String toString() {
		String result = "";
		
		for (int row = 0; row < NR_ROWS  ; row++){
			for (int col = 0; col < NR_COLS; col++){
				result += puzzle[row][col] + " ";
			}
			result += "\n";
		}
		
		return result;
	}
}
