package com.backtrack;

import java.util.Scanner;

public class Sudoku {
  
  /**
   * Driver method to solve sudoku.
   * @param args 
   */
	public static void main(String... args){
//		int[][] sudoku = readInput();
		int[][] sudoku = getSudoku();
		System.out.println("Initial\n");
		printSudoku(sudoku);
		solveSudoku(sudoku);
		System.out.println("\nFinal\n");
		printSudoku(sudoku);
	}
	
	/**
	 * This function prints sudoku passed as argument.
	 * @param sudoku Two dimensional array represents sudoku.
	 */
	public static void printSudoku(int[][] sudoku) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * This function defines and return sudoku.
	 * @return Sudoku as a two dimensional int array.
	 */
	public static int[][] getSudoku(){
		return new int[][] {
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
	}
	
	/**
	 * This function reads sudoku as input from console.
	 * @return Sudoku as two dimensional int array.
	 */
	public static int[][] readInput(){
		Scanner sc = new Scanner(System.in);
		int[][] sudoku = new int[9][9];
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sudoku[i][j] = sc.nextInt();
			}
		}
		sc.close();
		return sudoku;
	}

	/**
	 * This function checks if the number is valid to put in sudoku at the given position.
	 * @param sudoku Sudoku as two dimensional int array.
	 * @param row Row number as int to check for validity.
	 * @param col Column number as int to check for validity.
	 * @return True if number is valid at the specified position, else false.
	 */
	public static boolean isValid(int[][] sudoku, int row, int col) {
		int num = sudoku[row][col];
		
		//Check if same number is present in the corresponding row.
		for(int i=0;i<9;i++) {
			if(row!=i && sudoku[i][col]==num) {
				sudoku[row][col]=0;
				return false;
			}
		}
		
    //Check if same number is present in same column
		for(int i=0;i<9;i++) {
			if(col!=i && sudoku[row][i]==num) {
				sudoku[row][col]=0;
				return false;
			}
		}
		
    //Check if same number is present in corresponding 3*3 matrix
		for(int i=(row/3)*3;i<(row/3)*3+3;i++) {
			for(int j=(col/3)*3;j<(col/3)*3+3;j++) {
				if(i!=row && j!=col && sudoku[i][j]==num) {
					sudoku[row][col]=0;
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * This function solves sudoku by recursively calling itself. It first assigns a number and
	 * then checks if it is valid. If valid, same process happens for next empty index, if not then
	 * number is changed to next possible number.
	 * @param sudoku Sudoku as two dimensional int array
	 * @return True if solution exists, else false
	 */
	public static boolean solveSudoku(int[][] sudoku) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(sudoku[i][j]==0) {
					for(int k=1;k<=9;k++) {
						sudoku[i][j]=k;
						if(isValid(sudoku, i, j) && solveSudoku(sudoku)) {							
							return true;
						}
					}
					sudoku[i][j]=0;
					return false;
				}
			}
		}
		return true;
	}
}
